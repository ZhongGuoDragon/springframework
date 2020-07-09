package com.tom.soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Configuration
public class BlueDisc implements CompactDisc{
    public void play() {
        System.out.println("BlueDisc");
    }
}
