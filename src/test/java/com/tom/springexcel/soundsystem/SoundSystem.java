package com.tom.springexcel.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes=CDPlayerConfiger.class)
@RunWith(SpringJUnit4ClassRunner.class)

public class SoundSystem {
    //    @Autowired
//    private SgtPeppers cd;
//    @Autowired
//    private Soundpact sd;
    @Autowired
    private CDPlayer cd;
    @Autowired
    private Computer cp;
//    @Autowired
//    private CDPlayer cdp;
    @Test
    public void test() {
//        cd.play();
////        sd.play();
//        cp.run();
//        cdp.run();
        cd.run();
    }

//    public static void main(String[] args) {
//        ApplicationContext acx = new AnnotationConfigApplicationContext(CDPlayerConfiger.class);
//        CompactDisc cdPlayer = (CompactDisc) acx.getBean("cdPlayer");
//        cdPlayer.play();
//
//    }
}
