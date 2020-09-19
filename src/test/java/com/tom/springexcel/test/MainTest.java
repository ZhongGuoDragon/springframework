package com.tom.springexcel.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Person person = (Person) ctx.getBean("women");
        person.likePerson();
        Animal animal = (Animal)person;
        animal.eat();
    }

}
