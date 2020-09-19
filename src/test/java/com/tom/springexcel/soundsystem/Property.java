package com.tom.springexcel.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//@Qualifier("property")
@Configuration
@PropertySource("classpath:property.properties")
public class Property implements CompactDisc {
    @Autowired
    Environment evm;
    private String name;
    private String value;

//    @Bean
    public Property doProperty() {
//        System.out.println("doproperty");
//        return new Property(evm.getProperty("property.name"), evm.getProperty("property.value"));
        this.name = evm.getProperty("property.name");
        this.value = evm.getProperty("property.value");
        return null;
    }

    public Property() {

    }
    public Property(String name,String value) {
        this.name = name;
        this.value = value;
    }

    public void play() {
        this.doProperty();

        System.out.println(name + "     " + value);
    }
}
