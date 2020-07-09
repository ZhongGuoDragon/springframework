package com.tom.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AudienceConfig.class)
public class PerformanceTest {
//    @Qualifier("mm")
    @Autowired
    private Performance pf;
    @Autowired
    private Audience ad;
    @Test
    public void doTest() {
        try {
            pf.perform();
        } catch (Exception exception) {

        }
    }
}
