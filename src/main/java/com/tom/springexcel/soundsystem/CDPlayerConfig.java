package com.tom.springexcel.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CDPlayerConfig {
    @Bean
    public SgtPeppers sgtPeppers() {
        return new SgtPeppers();
    }
}
