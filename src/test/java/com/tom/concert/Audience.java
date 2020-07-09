package com.tom.concert;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(* com.tom.concert.Performance.perform(..))")
    public void performance() {
        System.out.println("audience.performance");
    }
    @Before("performance()")
    public void before() {
        System.out.println("audience.before");
    }

    @After("performance()")
    public void after() {
        System.out.println("Audience.After");
    }
    @AfterThrowing("performance()")
    public void afterThrowing() {
        System.out.println("audience.afterThrowing");
    }
    @AfterReturning("performance()")
    public void afterReturning() {
        System.out.println("audience.afterreturning");
    }

}
