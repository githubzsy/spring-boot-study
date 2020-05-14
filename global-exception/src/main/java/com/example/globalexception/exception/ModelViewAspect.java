package com.example.globalexception.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    //设置切入点：这里直接拦截被@ModelView注解的方法

    /**
     * 我们要对哪些方法面向切面编程
     * 当某个方法上加了com.example.globalexception.exception.ModelView注解后，我们对其进行处理
     */
    @Pointcut("@annotation(com.example.globalexception.exception.ModelView)")
    public void pointcut() {
    }

    /**
     * 当有ModelView的注解的方法抛出异常的时候，做如下的处理
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowable(Throwable e) {
        log.error("切面发生了异常：", e);
        if (e instanceof CustomException) {
            throw ModelViewException.transfer((CustomException) e);
        }
    }
}