package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyInterceptor1 implements HandlerInterceptor {
    //在目标方法执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        System.out.println("preHandle.....");
        String param = request.getParameter("param");
        if("yes".equals(param)){
            return true;
        }else{
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;//返回true代表放行  返回false代表不放行
        }
    }
    //目标方法执行之后，视图返回之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name","itheima");
        System.out.println("postHandle...");
    }
    //整个流程都执行完毕之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
