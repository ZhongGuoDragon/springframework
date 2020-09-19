package com.tom.springexcel.soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Primary
@Configuration
public class BlueDisc implements CompactDisc{
    public void play() {
        System.out.println("BlueDisc");
    }
}
