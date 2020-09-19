package com.tom.springexcel.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@EnableTransactionManagement
public class SqlSessionBuilder {



    @Bean
    public SqlSession getSqlSession() {

        SqlSessionFactory sqlSessionFactory = null;
        String resouces = "mybatis-config.xml";
        try {
            InputStream read = Resources.getResourceAsStream(resouces);
            synchronized (this) {
                if (sqlSessionFactory == null) {
                    sqlSessionFactory= new SqlSessionFactoryBuilder().build(read);
                }
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sqlSessionFactory.openSession(true);
    }
//    @Bean
//    public DataSourceTransactionManager getDataTransaction(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    public DataSource getDataSource() {
//        String url = "jdbc:mysql://localhost:3306/excel_schema?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String username = "root";
//        String password = "abc123456";
//        DataSource dataSource = new PooledDataSource(driver, url, username, password);
//        return dataSource;
//    }
}
