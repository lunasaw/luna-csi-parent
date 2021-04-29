package com.luna.csi.controller;

import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.admin.LoginService;
import com.luna.csi.req.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/login")
    public ResultDTO<Boolean> login(@RequestBody LoginReq loginReq, HttpServletResponse httpServletResponse) {
        boolean login = loginService.login(loginReq.getUsername(), loginReq.getPassword());

        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, login);
    }

}
