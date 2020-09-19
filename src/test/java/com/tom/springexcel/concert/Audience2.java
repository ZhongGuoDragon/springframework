package com.tom.springexcel.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience2 {
    @Pointcut("execution(* com.tom.springexcel.concert.Performance.perform(..))")
    public void doPerformance() {
    }

    @Around("doPerformance()")
    public void doAspect(ProceedingJoinPoint point) {
        try {
            System.out.println("Audience2.before");
            point.proceed();
            System.out.println("Audience2.After");
        } catch (Throwable throwable) {
            System.out.println("Audience.Throwable");
        }

    }
}
