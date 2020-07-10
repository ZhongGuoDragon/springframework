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
        int m = (int) (Math.random() * 1000);
        for (int i =m; i < m+100; i++) {
            spittles.add(new Spittle("Spittle" + i, new Date()));
        }
    }

    public List<Spittle> findSpittles(long max, int count) {
        MakeRepository m = new MakeRepository();

        int intmax=(int) max;
        if (intmax + count < m.spittles.size()) {
            count=m.spittles.size()-intmax-2;
        }
        return m.spittles.subList(intmax, intmax + count);
    }
}
