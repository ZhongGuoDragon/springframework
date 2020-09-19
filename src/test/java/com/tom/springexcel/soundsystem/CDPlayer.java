package com.tom.springexcel.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Configuration
public class CDPlayer implements MediaPlayer{
    @Autowired
    private SgtPeppers cd;

    //    @Autowired
//    @Bean
//    public CDPlayer  getCD(SgtPeppers sg) {
//
//        return new CDPlayer(sg);
//    }

    public CDPlayer() {

    }
    public CDPlayer(CompactDisc ss) {
        this.cd = (SgtPeppers) ss;
    }

    public void run() {
        cd.play();
        System.out.println("cdrun");
    }
}
