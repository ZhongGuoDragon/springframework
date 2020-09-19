package com.tom.springexcel.soundsystem;

import org.springframework.context.annotation.Configuration;

//
//@Component
@Configuration
public class SgtPeppers implements CompactDisc {

    public void play() {
        System.out.println("SgtPeppers");
    }
}
