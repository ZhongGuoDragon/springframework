package com.tom.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BlankDiscConfig.class)

public class BlankDiscTest {
//    @Qualifier("blankDisc")
    @Autowired
    private BlankDisc bd;
    @Autowired
    private Track tc;
    @Test
    public void doTest() {
        bd.playTrack(1);
        System.out.println(tc.getCount(1));
        bd.playTrack(1);
        System.out.println(tc.getCount(1));
        bd.playTrack(1);
        System.out.println(tc.getCount(1));
        bd.playTrack(1);
        System.out.println(tc.getCount(1));
        bd.playTrack(1);
        System.out.println(tc.getCount(1));
//        SumCount xx=(SumCount) tc;
//        TrackCounter tct=(TrackCounter) tc;
//        xx.doCount(tc.getTrackCount());
    }
}
