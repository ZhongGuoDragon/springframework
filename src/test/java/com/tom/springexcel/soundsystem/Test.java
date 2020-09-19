package com.tom.springexcel.soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:config/test.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\hello-world\\src\\test\\java\\com\\tom\\soundsystem\\test.xml");
//        CompactDisc sg =(CompactDisc)ac.getBean("blankdisc");
//        sg.play();
//        CompactDisc hh = ac.getBean(SgtPeppers.class);
//        CDPlayer cd = ac.getBean(CDPlayer.class);
//        cd.run();
//        ResDisc rd = ac.getBean(ResDisc.class);
//        rd.run();
//        SgtPeppers bean = SpringBeanUtil.getBean(SgtPeppers.class);
//        bean.play();
        CompactDisc hh = ac.getBean(BlankDisc.class);
        hh.play();
        CDPlayer cd = ac.getBean(CDPlayer.class);
        cd.run();
        CompactDisc ch = ac.getBean(SgtPeppers.class);
        ch.play();
        CompactDisc cad = ac.getBean(BlueDisc.class);
        cad.play();
    }

}
