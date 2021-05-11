package com.luna.csi;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.luna.baidu.api.BaiduUserFaceApi;
import com.luna.baidu.config.BaiduProperties;
import com.luna.baidu.dto.face.UserFaceResultDTO;
import com.luna.common.encrypt.Md5Utils;
import com.luna.common.file.FileUtils;
import com.luna.common.text.Base64Util;
import com.luna.csi.entity.User;
import com.luna.redis.util.RedisHashUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luna@mac
 * 2021年04月29日 10:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginTest {

    public static void main(String[] args) {
        System.out.println(Md5Utils.md5(Md5Utils.md5("admin123")));
    }

    @Autowired
    private RedisHashUtil redisHashUtil;

    @Test
    public void atest() {
        User user = new User();
        redisHashUtil.set("luna:session:", ImmutableMap.of("sessionKey", user));
    }

    @Autowired
    private BaiduProperties baiduProperties;

    @Test
    public void btest() {
        System.out.println(baiduProperties.getBaiduKey());
        UserFaceResultDTO userFaceResultDTO = BaiduUserFaceApi.faceUserAdd(baiduProperties.getBaiduKey(),
            Base64Util.encodeBase64(
                FileUtils.readFileToBytes("/Users/luna_mac/csi/2021/05/07/4e732ced3463d06de0ca9a15b6153677.jpg")),
            "BASE64", "luna-csi", "26");
        System.out.println(JSON.toJSONString(userFaceResultDTO));
    }
}
