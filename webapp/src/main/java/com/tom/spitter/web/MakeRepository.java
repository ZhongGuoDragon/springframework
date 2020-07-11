package com.tom.spitter.web;

import com.tom.spitter.Spittle;
import com.tom.spitter.data.SpittleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MakeRepository implements SpittleRepository {
    private List<Spittle> spittles;
    public MakeRepository() {
        spittles = new ArrayList<Spittle>();
        int m = 0;
        for (int i =m; i < m+100; i++) {
            spittles.add(new Spittle((long)i,"Spittle"+i,new Date(),0.0,0.00));
        }
    }

    public List<Spittle> findSpittles(long max, int count) {

        return this.spittles.subList((int)max,count);
    }
}
