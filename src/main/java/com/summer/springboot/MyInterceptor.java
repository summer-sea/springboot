package com.summer.springboot;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-26 12:28
 * springboot 注册拦截器
 * 通过实现HandlerInterceptor接口来定义
 * 在webmvcconfig中来注册拦截器
 **/

public class MyInterceptor implements HandlerInterceptor {

    //只有第一个方法返回true 后面的方法才会执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
    }
}
