package com.tom.springexcel.concert;

import org.aspectj.lang.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Aspect
//@Component
public class TrackCounter implements Track{
    private Map<Integer, Integer> trackCount=new HashMap<Integer, Integer>();


    @Pointcut("execution(* com.tom.springexcel.concert.CompactDisc.playTrack(int))&&args(numTrack)")
    public void trackPlayed(int numTrack) {
    }

    @Before("trackPlayed(numTrack)")
    public void addTrack(int numTrack) {
        trackCount.put(numTrack, this.getCount(numTrack) + 1);
        System.out.println(this.getCount(numTrack));
    }

    public void test() {
        System.out.println("TrackCounter.Test");
    }
    public int getCount(int ntrack) {
        return this.trackCount.containsKey(ntrack) ? this.trackCount.get(ntrack) : 0;
    }

    public Map<Integer,Integer> getTrackCount() {
        return this.trackCount;
    }
}
