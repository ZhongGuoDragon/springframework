package com.tom.spitter.data;

import java.util.List;

public interface SpittleRepository<E> {
    List<E> findSpittles(long max, int conunt);

    public void save(E e);

    public E get(int n);

    public E find(long id);

    public void add(E e);

}
