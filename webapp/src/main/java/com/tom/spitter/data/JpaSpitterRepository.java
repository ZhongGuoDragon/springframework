package com.tom.spitter.data;

import com.tom.spitter.Spittle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class JpaSpitterRepository {
//    @PersistenceContext
//    private EntityManager em;
//
//    public void addSpitter(long id) {
//        Spittle s;
//        s=em.find(Spittle.class, id);
//        System.out.println(s.getTime());
//
////        em.persist(spittle);
//
//    }

}
