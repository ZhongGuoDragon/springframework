package com.tom.spitter.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class DataConfigSecond {
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter jp) {
//        System.out.println(".....................2222222222222222.........................");
//        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
//        System.out.println(".....................3333333333333333333.........................");
//        emfb.setDataSource(dataSource);
//        System.out.println(".....................444444444444444444.........................");
//        emfb.setJpaVendorAdapter(jp);
//        System.out.println(".....................5555555555555555555.........................");
//        return emfb;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        System.out.println(".....................1111111.........................");
//        HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
////        EclipseLinkJpaVendorAdapter hjva=new EclipseLinkJpaVendorAdapter();
//        System.out.println(".............aaaaaaaaaaaaaaaaaaaaaa................");
//        hjva.setShowSql(true);
//        hjva.setDatabase(Database.MYSQL);
//        hjva.setGenerateDdl(false);
//        hjva.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//        return hjva;
//    }
    @Bean
    public PersistenceAnnotationBeanPostProcessor postProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

}
