package com.tom.springexcel.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class Soundpact implements CompactDisc {
    public void play() {
        System.out.println("456");
    }
//    @Bean
//    public Soundpact build() {
//        return new Soundpact();
//    }
}
