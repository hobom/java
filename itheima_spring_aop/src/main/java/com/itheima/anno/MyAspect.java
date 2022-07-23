package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前为一个切面类
public class MyAspect {

    //配置前置增强
    //@Before("execution(* com.itheima.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强...");
    }

    public void afterReturning(){
        System.out.println("后置增强...");
    }

    //ProceedingJoinPoint:正在执行的连接点
//    @Around("execution(* com.itheima.anno.*.*(..))")
    @Around("pointcut()")
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

    //定义切点表达式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public void pointcut(){}
}
