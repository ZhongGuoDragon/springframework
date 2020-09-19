package com.tom.springexcel.concert;

import org.aspectj.lang.annotation.DeclareParents;

//@Aspect
//@Configuration
public class TrackCounterConfig {
    @DeclareParents(value="com.tom.springexcel.concert.Track+",defaultImpl = TrackSum.class)
    public static SumCount trackcounter;
}
