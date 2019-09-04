package com.imooc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * LN
 * 2019/9/4 0004 10:22
 */
//@Aspect      //将这个类声明为切片
//@Component   //变为我spring容器的一部分
public class TimeAspect {
    //execution:执行
    //com.imooc.web.controller.UserController.*：类中所有的方法
    @Around("execution(* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg.toString());
        }
        long start = new Date().getTime();
        Object proceed = pjp.proceed();//相当于调用了要拦截的方法,返回值就是方法返回的结果
        System.out.println("time aspect 耗时：" + (new Date().getTime() - start));
        System.out.println("time aspect end");
        return proceed;
    }
}
