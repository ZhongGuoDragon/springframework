package com.tom.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

@ContextConfiguration(classes=CDPlayerConfiger.class)
@RunWith(SpringJUnit4ClassRunner.class)

public class SoundSystemTest {
    @Autowired
    private SgtPeppers cd;
//    @Autowired
//    private Soundpact sd;
    @Test
    public void test() {
        cd.play();
//        sd.play();
    }

//    public static void main(String[] args) {
//        ApplicationContext acx = new AnnotationConfigApplicationContext(CDPlayerConfiger.class);
//        CompactDisc cdPlayer = (CompactDisc) acx.getBean("cdPlayer");
//        cdPlayer.play();
//
//    }
}
