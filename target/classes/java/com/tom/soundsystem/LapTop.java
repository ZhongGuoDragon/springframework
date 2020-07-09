package com.tom.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class LapTop implements Computer {
    public void run() {
        System.out.println("laptop");
    }
//    @Bean
//    public Computer build() {
//        return new Computer() {
//            public void run() {
//                System.out.println("new Computer");
//
//            }
//        };
    }
