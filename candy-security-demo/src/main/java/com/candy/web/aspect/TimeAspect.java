package com.candy.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;
import java.util.Arrays;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/31 18:01
 */
//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.candy.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint point)
            throws Throwable {
        System.out.println("time aspect start");
        Object[] args = point.getArgs();
        Arrays.stream(args).forEach(arg->{
            System.out.println(arg.getClass().getName());
            System.out.println("arg is " + arg);
        });
        long startTime = new Date().getTime();
        Object obj = point.proceed();
        System.out.println("time aspect 耗时" + (new Date().getTime() - startTime));
        System.out.println("time aspect end");
        return obj;
    }


}
