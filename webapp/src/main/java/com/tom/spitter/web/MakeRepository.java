package com.tom.spitter.web;

import com.tom.spitter.Spittle;
import com.tom.spitter.data.SpittleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MakeRepository implements SpittleRepository<Spittle> {
    private List<Spittle> saves;
    private List<Spittle> spittles;
    public MakeRepository() {
        saves = new ArrayList<Spittle>();
        spittles = new ArrayList<Spittle>();
        int m = 0;
        for (int i =m; i < m+100; i++) {
            spittles.add(new Spittle((long)i,"Spittle"+i,new Date(),0.0,0.00));
        }
    }

    public List<Spittle> findSpittles(long max, int count) {

        return this.spittles.subList((int)max,count);
    }

    public void save(Spittle spittle) {
        System.out.println("????????????????");
        if (spittle == null) {
            System.out.println("spittle is null");

        }
        saves.add(spittle);
        System.out.println(saves.get(0).getMessage());
    }

    public Spittle get(int n) {
        for (int i = 0; i < saves.size(); i++) {
            if (saves.get(i).getId() == n) {
                return saves.get(i);
            }
        }
        return null;
    }

    public Spittle find(long id) {
        if ((int) id >= spittles.size()) {
            return null;
        }
        return spittles.get((int) id);
    }

    public void add(Spittle spittle) {
        for (Spittle se : spittles) {
            if (se.getId() == spittle.getId()) {
                throw new DuplicateSpittleException("Not Found");
            }
        }
        spittles.add(spittle);
    }
}
