package com.tom.mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class SqlSessionBuilder {
    @Bean
    public SqlSession SqlSessionBuilders() throws IOException {
        SqlSessionFactory sqlSessionFactory = null;
        String resources = "mybatis-config.xml";
        System.out.println(Resources.getResourceURL(resources));
        InputStream read = Resources.getResourceAsStream(resources);
//        InputStreamReader isr = new InputStreamReader(read);//读取
        //综合到一句。
        //InputStreamReader isr = new InputStreamReader(
        //new FileInputStream("D:\\demo.txt"));

//        char []cha = new char[4024];
//        int len = isr.read(cha);
//        System.out.println(new String(cha,0,len));
//        isr.close();

        synchronized (this) {

            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(read);
                System.out.println(read.toString());
            }
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return sqlSessionFactory.openSession();
    }
}
