package com.tom.spitter.db;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DataRepository extends JpaRepository<Spittles,Long> {
    Spittles findByMessage(String message);

}
