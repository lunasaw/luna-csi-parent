package com.luna.csi.admin;

import com.google.common.collect.ImmutableMap;
import com.luna.baidu.api.BaiduUserFaceApi;
import com.luna.baidu.config.BaiduProperties;
import com.luna.baidu.dto.face.UserFaceResultDTO;
import com.luna.baidu.dto.face.UserInfoListDTO;
import com.luna.baidu.dto.face.UserInfoResultDTO;
import com.luna.common.date.DateUtil;
import com.luna.common.dto.constant.ResultCode;
import com.luna.common.encrypt.Md5Utils;
import com.luna.common.file.FileUtils;
import com.luna.common.text.Base64Util;
import com.luna.common.text.RandomStrUtil;
import com.luna.csi.config.LoginInterceptor;
import com.luna.csi.controller.CommonController;
import com.luna.csi.entity.User;
import com.luna.csi.exception.UserException;
import com.luna.csi.mapper.UserMapper;
import com.luna.csi.utils.FileUploadUtils;
import com.luna.redis.util.RedisHashUtil;
import com.luna.redis.util.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author luna@mac
 * 2021年05月07日 19:06
 */
@Service
public class FaceService {

    private static final Logger log      = LoggerFactory.getLogger(FaceService.class);
    /** 人员组名 */
    public static final String  LUNA_CSI = "luna_csi";
    /** 控制检测分数 */
    public static final int     SCORE    = 90;

    @Autowired
    private UserMapper          userMapper;

    @Autowired
    private RedisHashUtil       redisHashUtil;

    @Autowired
    private BaiduProperties     baiduProperties;

    @Autowired
    private RedisKeyUtil        redisKeyUtil;

    public Boolean registerFace(String sessionKey, String faceUrl) {
        User user = (User)redisHashUtil.get(LoginInterceptor.sessionKey + ":" + sessionKey, sessionKey);
        User byId = userMapper.getById(user.getId());
        if (byId == null) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "用户不存在");
        }
        String path = FileUploadUtils.getDefaultBaseDir() + "/" + DateUtil.datePath() + "/"
            + Md5Utils.md5(String.valueOf(user.getId())) + ".jpg";
        FileUtils.writeBytesToFile(Base64Util.decodeBase64(faceUrl), path);
        UserFaceResultDTO userFaceResultDTO = BaiduUserFaceApi.faceUserAdd(baiduProperties.getBaiduKey(),
            faceUrl, "BASE64", LUNA_CSI, String.valueOf(byId.getId()));
        byId.setFacedata(userFaceResultDTO.getFaceToken());
        byId.setFaceurl(CommonController.PATH + path);
        return userMapper.update(byId) == 1;
    }

    /**
     * 人脸检查
     * 
     * @param faceUrl
     * @return
     */
    public String login(String faceUrl) {
        UserInfoListDTO userInfoListDTO =
            BaiduUserFaceApi.userFaceSearch(baiduProperties.getBaiduKey(), faceUrl, "BASE64", LUNA_CSI);
        List<UserInfoResultDTO> userList = userInfoListDTO.getUserList();
        String nonceStrWithUUID = RandomStrUtil.generateNonceStrWithUUID();
        userList.forEach(userInfoResultDTO -> {
            if (userInfoResultDTO.getScore() > SCORE) {
                long l = Long.parseLong(userInfoResultDTO.getUserId());
                User user = userMapper.getById(l);
                // 登陆图片
                String checkPath = FileUploadUtils.getDefaultBaseDir() + "/" + DateUtil.datePath() + "/"
                    + Md5Utils.md5(String.valueOf(user.getId())) + ".jpg";

                Path path = Paths.get(checkPath);
                if (!Files.isDirectory(path)) {
                    path = path.getParent();
                }
                try {
                    Files.createDirectories(path);
                } catch (IOException ignored) {

                }

                FileUtils.writeBytesToFile(Base64Util.decodeBase64(faceUrl), checkPath);
                redisHashUtil.set(LoginInterceptor.sessionKey + ":" + nonceStrWithUUID,
                    ImmutableMap.of(nonceStrWithUUID, user));
                redisKeyUtil.expire(LoginInterceptor.sessionKey + ":" + nonceStrWithUUID,
                    7 * 60 * 60 * LoginService.SESSION_EXPIRED_HOUR,
                    null);
            }
        });
        return nonceStrWithUUID;
    }
}
