package com.tom.springexcel.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfiger {
    @Bean
    //通过该注解实现java代码装配bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
//    @Bean
//    public CDPlayer cdPlayer(){
//        //依赖于 CompactDisc 的bean
//        return new CDPlayer(sgtPeppers());
//    }
}
