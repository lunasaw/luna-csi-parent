package com.luna.csi.admin;

import com.google.common.collect.ImmutableMap;
import com.luna.common.dto.constant.ResultCode;
import com.luna.common.encrypt.Md5Utils;
import com.luna.common.text.RandomStrUtil;
import com.luna.csi.config.LoginInterceptor;
import com.luna.csi.entity.User;
import com.luna.csi.exception.UserException;
import com.luna.csi.service.UserService;
import com.luna.csi.utils.CookieUtils;
import com.luna.redis.util.RedisHashUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luna@mac
 * 2021年04月29日 10:02
 */
@Service
public class LoginService {

    @Autowired
    private UserService   userService;

    @Autowired
    private RedisHashUtil redisHashUtil;

    public String login(String username, String password) {
        User user = userService.getByEntity(new User(username));
        if (user == null) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "用户不存在");
        }

        String s = Md5Utils.md5(Md5Utils.md5(password));
        if (!StringUtils.equals(user.getPassword(), s)) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "密码错误");
        }

        String nonceStrWithUUID = RandomStrUtil.generateNonceStrWithUUID();
        redisHashUtil.set(LoginInterceptor.sessionKey, ImmutableMap.of(nonceStrWithUUID, user));
        return nonceStrWithUUID;
    }

    public User sysUser(String sessionKey) {
        return (User)redisHashUtil.get(LoginInterceptor.sessionKey, sessionKey);
    }

    public Boolean editPassword(String sessionKey, String oldPassword, String newPassword) {
        User user = (User)redisHashUtil.get(LoginInterceptor.sessionKey, sessionKey);
        User byId = userService.getById(user.getId());

        if (!byId.getPassword().equals(Md5Utils.md5(Md5Utils.md5(oldPassword)))) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "密码错误");
        }

        byId.setPassword(Md5Utils.md5(Md5Utils.md5(newPassword)));
        return userService.update(byId) == 1;
    }
}
