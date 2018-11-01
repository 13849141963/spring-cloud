package com.zy.cn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * this is a acpect
 * 切入点
 * 在那些方法上起作用
 * 在什么时候起作用
 *
 * @author hsj
 * @create 2017-11-11 20:52
 **/
@Aspect
@Component
public class ApiAspect {

    // 切面
    @Around("execution(* com.zy.cn.controller.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("执行切面方法~~~~~~~~~~");
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg.getClass().getName());
            System.out.println("arg is " + arg);
        }
        long startTime = new Date().getTime();
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("time aspect 耗时" + (new Date().getTime() - startTime));
        System.out.println("time aspect end");
        System.out.println("切面执行完毕~~~~~~~~~~");
        return obj;
    }
}
