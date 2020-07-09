package com.tom.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CDConfig {

//    @Bean
    public SgtPeppers compactDisc() {
        return new SgtPeppers();
    }
}
