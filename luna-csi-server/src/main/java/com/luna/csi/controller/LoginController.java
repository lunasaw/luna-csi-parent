package com.luna.csi.controller;

import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.admin.LoginService;
import com.luna.csi.entity.User;
import com.luna.csi.req.EditPasswordReq;
import com.luna.csi.req.LoginReq;
import com.luna.csi.utils.CookieUtils;
import com.luna.redis.util.RedisHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luna@mac
 * 2021年04月29日 09:59
 */
@RestController
@RequestMapping("/user/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /** session过期时间，单位小时 */
    int                  SESSION_EXPIRED_HOUR = 24;

    @PostMapping("/login")
    public ResultDTO<String> login(@RequestBody LoginReq loginReq, HttpServletResponse response) {
        String sessionKey = loginService.login(loginReq.getUsername(), loginReq.getPassword());
        Cookie cookie = new Cookie(CookieUtils.SESSION_KEY_NAME, sessionKey);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * SESSION_EXPIRED_HOUR);
        response.addCookie(cookie);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, sessionKey);
    }

    @GetMapping("/sysUser")
    public ResultDTO<User> sysUser(HttpServletRequest request) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            loginService.sysUser(CookieUtils.getOneSessionKey(request)));
    }

    @PostMapping("/editPassword")
    public ResultDTO<Boolean> editPassword(HttpServletRequest request, @RequestBody EditPasswordReq editPasswordReq) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            loginService.editPassword(CookieUtils.getOneSessionKey(request), editPasswordReq.getOldPassword(),
                editPasswordReq.getNewPassword()));
    }
}
