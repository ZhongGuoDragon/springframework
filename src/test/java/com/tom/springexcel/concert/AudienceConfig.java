package com.tom.springexcel.concert;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
//@EnableAspectJAutoProxy
@ImportResource("classpath:concert.xml")
public class AudienceConfig {

    @Primary
    @Bean
    public Performance performance() {
        return new BadPerformance();
    }
    @Bean(name="goodPerformance")
    @Qualifier("mm")
    public Performance performancep() {
        return new GoodPerformance();
    }
    @Bean
    public Audience getAudience() {
        return new Audience();
    }
    @Bean
    public Audience2 getAudience2() {
        return new Audience2();
    }

//    @Bean
//    public Audience audience() {
//        return new Audience();
//    }
}
