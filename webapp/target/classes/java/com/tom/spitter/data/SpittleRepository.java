package com.tom.spitter.data;

import com.tom.spitter.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int conunt);
}
