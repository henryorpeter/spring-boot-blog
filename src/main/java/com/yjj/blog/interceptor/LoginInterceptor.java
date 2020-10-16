package com.yjj.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: JKing
 * \* Date: 2020/10/16
 * \* Time: 20:32
 * \*建立登录拦截器，重新定向到admin页面，避免非法访问！！！！！！！！！！！*-
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}