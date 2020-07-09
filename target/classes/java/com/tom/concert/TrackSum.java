package com.tom.concert;

import java.util.Map;

public class TrackSum implements SumCount{
    public void doCount(Map<Integer, Integer> list) {
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum=list.get(i)+sum;
        }
        System.out.println(sum);
        System.out.println("TrackSum");
    }
}
