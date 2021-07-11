package com.example.myblog.interceptor;



import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录状态验证
public class Loginterceptor extends HandlerInterceptorAdapter {

  /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user")==null){
         response.sendRedirect("/admin");
            return true;
        }
        return true;
    }*/
}
