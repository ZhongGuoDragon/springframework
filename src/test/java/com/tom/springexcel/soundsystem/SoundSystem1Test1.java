package com.tom.springexcel.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = CDPlayerConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)

public class SoundSystem1Test1 {
//    @Value("#{reddisc.tracks.?[String = 2]}")
    private List list;
    @Autowired
    private SgtPeppers cd;
    @Autowired
    private CDPlayer cp;

    @Autowired
    private ResDisc rd;
    @Autowired
    private BlueDisc bd;
    @Qualifier("bkd")
    @Autowired
    private CompactDisc cpd;
    @Qualifier("mul")
    @Autowired
    private CompactDisc c1;
    @Qualifier("property")
    @Autowired
    private CompactDisc c2;
//    @Qualifier("mul")
    @Autowired
    private Property c3;

//    @Autowired
//    private Soundpact sd;
//    @Autowired
//    private Computer ca;
//    @Autowired
//    private CDPlayer cdp;
    @Test

    public void test() {

//        cd.play();
////        sd.play();
//        cp.run();
//        cdp.run();
//        cp.run();
        cd.play();
        cpd.play();
        c1.play();
        c2.play();
        c3.play();
//        ca.run();
//        bd.play();
//
//        cp.run();
//        rd.run();
        System.out.println(list);

    }

//    public static void main(String[] args) {
//        ApplicationContext acx = new AnnotationConfigApplicationContext(CDPlayerConfiger.class);
//        CompactDisc cdPlayer = (CompactDisc) acx.getBean("cdPlayer");
//        cdPlayer.play();
//
//    }
}
