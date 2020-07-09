package com.tom.test;

import org.springframework.stereotype.Component;

@Component("women")
public class Women implements Person{

    public void likePerson() {
        System.out.println("我是女生，我喜欢帅哥");
    }
}
