package com.tom.springexcel.config;

import com.tom.springexcel.mapper.FormatMapper;
import com.tom.springexcel.mapper.OriginalMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableTransactionManagement

public class SqlSessionBuilder {
    @Autowired
    Logger logger;




//    @Bean
//    public SqlSession getSqlSession() {
//
//        SqlSessionFactory sqlSessionFactory = null;
//        String resouces = "mybatis-config.xml";
//        try {
//            InputStream read = Resources.getResourceAsStream(resouces);
//            synchronized (this) {
//                if (sqlSessionFactory == null) {
//                    sqlSessionFactory= new SqlSessionFactoryBuilder().build(read);
//                }
//            }
//
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//        return sqlSessionFactory.openSession();
//    }
//    @Bean
//    public DataSourceTransactionManager getDataTransaction(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//


    @Lazy
    @Bean
    public DataSource getDataSource() {
        String url = "jdbc:mysql://localhost:3306/excel_schema?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true";
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "abc123456";
//        Properties properties = new Properties();
//        properties.setProperty("driver", driver);
//        properties.setProperty("username", username);
//        properties.setProperty("password", password);
        {        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }}


        DataSource dataSource = new DriverManagerDataSource(url,username,password);
        return dataSource;
    }
    @Lazy
    @Bean(name="sqlsessionfactorybean")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource resource = new DefaultResourceLoader().getResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        try  {
            logger.info(resource.getURI());
        } catch (Exception exception) {
            logger.error(exception.toString());
        };

        return sqlSessionFactoryBean;
    }

    @Lazy
    @Bean(name="sqlsessiontemplate")
    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean
//    public SqlSession getSqlSession(SqlSessionTemplate sqlSessionTemplate) {
//        return sqlSessionTemplate;
//    }

//    @Bean
//    public PlatformTransactionManager getPlatformTransactionManager() {
//        return new
//    }
//    @Bean
//    public PersistenceAnnotationBeanPostProcessor postProcessor() {
//        return new PersistenceAnnotationBeanPostProcessor();
//    }

    @Bean
    @Lazy
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

//    @Bean
//    @Lazy
//    public MapperFactoryBean getMapperFactoryBean(SqlSessionTemplate sqlSessionTemplate,SqlSessionFactory sqlSessionFactory) {
//        MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
//        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//        mapperFactoryBean.setSqlSessionTemplate(sqlSessionTemplate);
//        mapperFactoryBean.setMapperInterface(FormatMapper.class);
//        mapperFactoryBean.setMapperInterface(OriginalMapper.class);
//        return mapperFactoryBean;
//    }
//
//    @Bean
//    @Lazy
//    public MapperScannerConfigurer getMapperScannerConfigurer(SqlSessionTemplate sqlSessionTemplate,SqlSessionFactory sqlSessionFactory) {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setAnnotationClass(Repository.class);
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlsessionfactorybean");
//        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlsessiontemplate");
////        mapperScannerConfigurer.setSqlSessionTemplate(sqlSessionTemplate);
////        mapperScannerConfigurer.setSqlSessionFactory(sqlSessionFactory);
//        mapperScannerConfigurer.setBasePackage("com.tom.springexcel.mapper");
//        return mapperScannerConfigurer;
//    }
}
