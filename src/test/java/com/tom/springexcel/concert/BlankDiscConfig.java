package com.tom.springexcel.concert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:BlackDisc.xml")
@EnableAspectJAutoProxy
@ComponentScan
public class BlankDiscConfig {
//    @Autowired
//    private static BlankDisc bd;
//    public static void main(String[] args) {
//        bd.playTrack(1);
//    }
}
