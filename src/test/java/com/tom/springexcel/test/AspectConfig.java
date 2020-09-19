package com.tom.springexcel.test;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
    @DeclareParents(value = "com.tom.springexcel.test.Person+", defaultImpl = FemaleAnimal.class)
    public Animal animal;
}
