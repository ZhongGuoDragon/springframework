package com.tom.springexcel.soundsystem;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@Import(CDConfig.class)
@ImportResource("classpath:test.xml")
public class CDPlayerConfig {
//    @Bean
//    public SgtPeppers sgtPeppers() {
//        return new SgtPeppers();
//    }
//    @Bean
//    public CDPlayer cdPlayer(CompactDisc compactDisc) {
//        return new CDPlayer(compactDisc);
//    }
//    @Bean
//    public BlueDisc cd() {
//        return new BlueDisc();
//    }
//    @Bean
//    public SgtPeppers sg(CompactDisc cd) {
//        return new SgtPeppers();
//    }
}
