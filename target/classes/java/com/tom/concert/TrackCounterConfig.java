package com.tom.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Aspect
//@Configuration
public class TrackCounterConfig {
    @DeclareParents(value="com.tom.concert.Track+",defaultImpl = com.tom.concert.TrackSum.class)
    public static SumCount trackcounter;
}
