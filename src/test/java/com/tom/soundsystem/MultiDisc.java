package com.tom.soundsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
@Qualifier("mul")
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MultiDisc implements CompactDisc {
    private Date date;

    public MultiDisc() {

        this.date = new Date();
        try  {
            Thread.sleep(500);
        } catch (Exception exception) {

        }
    }

    public void play() {
        System.out.println(date);
    }
}
