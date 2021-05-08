package com.luna.csi.controller;

import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.admin.FaceService;
import com.luna.csi.admin.LoginService;
import com.luna.csi.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author luna@mac
 * 2021年05月07日 19:02
 */
@RestController
@RequestMapping("/user/api")
public class FaceController {

    @Autowired
    private FaceService faceService;

    @PostMapping("/registerFace")
    public ResultDTO<Boolean> registerFace(HttpServletRequest request, String faceUrl) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            faceService.registerFace(CookieUtils.getOneSessionKey(request), faceUrl));
    }

    @PostMapping("/faceLogin")
    public ResultDTO<String> checkFace(HttpServletResponse response, String faceUrl) {
        String sessionKey = faceService.login(faceUrl);
        Cookie cookie = new Cookie(CookieUtils.SESSION_KEY_NAME, sessionKey);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, sessionKey);
    }

}
