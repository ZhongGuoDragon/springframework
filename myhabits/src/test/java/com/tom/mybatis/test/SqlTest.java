package com.tom.mybatis.test;

import com.tom.mybatis.config.SqlSessionBuilder;
import com.tom.mybatis.mapper.HealthMaleMapper;
import com.tom.mybatis.mapper.RoleMapper;
import com.tom.mybatis.pojo.Role;
import com.tom.mybatis.pojo.Sex;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SqlSessionBuilder.class)
public class SqlTest {
    @Autowired
    SqlSession sqlSession;

    @Test
    public void doTest2() {
//        StudentCardMapper mapper1 = sqlSession.getMapper(StudentCardMapper.class);
//        System.out.println(mapper1.getStudentCardById(1));
//        LectureScoreMapper mapper = sqlSession.getMapper(LectureScoreMapper.class);
//        System.out.println(mapper.getLectureScore(1));
//        StudentMapper mapper2 = sqlSession.getMapper(StudentMapper.class);
//        System.out.println(mapper2.getStudent(1));
        HealthMaleMapper mapper2 = sqlSession.getMapper(HealthMaleMapper.class);
        System.out.println(mapper2.getHealthMale(3));
    }
    public void doTest() {
        RoleMapper mapper=sqlSession.getMapper(RoleMapper.class);
        System.out.println(mapper.getRole(240l));
        mapper.insertRole("happy", new Date());
        System.out.println(mapper.insertRole("happy", new Date()));
        System.out.println(mapper.updateRole(200, 200));
        System.out.println(mapper.deleteRole("123"));
        System.out.println(mapper.insertSex(Sex.FEMALE));
        Role role = new Role(Long.valueOf(310l), "ssss", new Date(), Sex.MALE);
        System.out.println(mapper.insertRole3(role));
        System.out.println(role);
        sqlSession.commit();
        System.out.println();

//        SpittlesMapper mapperr = sqlSession.getMappe
//        r(SpittlesMapper.class);
//        System.out.println(mapperr.getSpittles(123));
    }



}
