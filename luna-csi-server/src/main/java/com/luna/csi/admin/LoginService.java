package com.luna.csi.admin;

import com.luna.common.dto.constant.ResultCode;
import com.luna.common.encrypt.Md5Utils;
import com.luna.csi.entity.User;
import com.luna.csi.exception.UserException;
import com.luna.csi.service.UserService;
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
    private UserService userService;

    public boolean login(String username, String password) {
        User user = userService.getByEntity(new User(username));
        if (user == null) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "用户不存在");
        }

        String s = Md5Utils.md5(Md5Utils.md5(password));
        if (!StringUtils.equals(user.getPassword(), s)) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "密码错误");
        }

        return true;
    }

}