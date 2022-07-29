package com.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ps
 * @Description:
 * @Date: Created in 2019/11/4 18:38
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {

        // 是否通过
        boolean flg = true;

        //获取token
        String localToken = (String) request.getSession().getAttribute("token");

        if(StringUtils.isBlank(localToken)){
            response.sendRedirect("/cross/login.html");
            return false;
        }

        return flg;
    }
}
