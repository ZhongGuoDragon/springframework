package com.tom.springexcel.soundsystem;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {

//    @Bean
    public SgtPeppers compactDisc() {
        return new SgtPeppers();
    }
}
