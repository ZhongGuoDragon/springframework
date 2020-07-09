package com.tom.soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
//
//@Component
@Configuration
public class SgtPeppers implements CompactDisc {

    public void play() {
        System.out.println("SgtPeppers");
    }
}
