package com.luna.csi.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luna.csi.entity.User;
import com.luna.csi.utils.CookieUtils;
import com.luna.redis.util.RedisHashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;

/**
 * @author luna@mac
 * 2021年04月10日 10:37
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger log        = LoggerFactory.getLogger(LoginInterceptor.class);

    public static String        sessionKey = "luna:session:";

    @Autowired
    private RedisHashUtil       redisHashUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        String oneSessionKey = CookieUtils.getSessionKeyFromRequest(request);
        if (oneSessionKey != null) {
            User user = (User)redisHashUtil.get(sessionKey, oneSessionKey);
            if (user != null) {
                return true;
            } else {
                response.setHeader("Content-Type", "application/json");
                PrintWriter printWriter = response.getWriter();
                printWriter.write(JSON.toJSONString(
                    new ResultDTO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION)));
                printWriter.flush();
                printWriter.close();
            }
        }
        // 若不满验证，则直接跳转到登录界面
        response.sendRedirect(request.getContextPath() + "/login");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {

    }
}
