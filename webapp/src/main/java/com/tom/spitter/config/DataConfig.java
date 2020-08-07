package com.tom.spitter.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class DataConfig {
    @Bean
    public SqlSession getSqlSession() {
        String resource = "mybatis-config.xml";
        try {
            InputStream stream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            return sessionFactory.openSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
