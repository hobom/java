package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before(){
        System.out.println("前置增强...");
    }

    public void afterReturning(){
        System.out.println("后置增强...");
    }

    //ProceedingJoinPoint:正在执行的连接点
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前...");
        //切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕后...");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("异常抛出...");
    }

    public void after(){
        System.out.println("最终增强，不管是否异常...");
    }
}
