package com.tom.spitter.web;

import com.tom.spitter.Spittle;
import com.tom.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
//@Repository
public class MakeRepository implements SpittleRepository<Spittle> {
    private List<Spittle> saves;
    private List<Spittle> spittles;
    private JdbcOperations jdbcOperations;
    private NamedParameterJdbcOperations namedjdbcOperation;
    @Lazy
    @Bean
    public DataSource datasource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/crashcourse?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("123456");
        return ds;
    }

    @Bean
    @Lazy
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplated(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
    @Lazy
    @Autowired
    public MakeRepository(JdbcOperations jdbcOperations,NamedParameterJdbcTemplate namedjdbcOperation) {
        this.jdbcOperations = jdbcOperations;
        this.namedjdbcOperation = namedjdbcOperation;



    }
//    public MakeRepository() {
//        saves = new ArrayList<Spittle>();
//        spittles = new ArrayList<Spittle>();
//        int m = 0;
//        for (int i =m; i < m+100; i++) {
//            spittles.add(new Spittle((long)i,"Spittle"+i,new Date(),0.0,0.00));
//        }
//    }

    public List<Spittle> findSpittles(long max, int count) {

        return this.spittles.subList((int)max,count);
    }


//
    public void save(Spittle spittle) {
        String sql = "INSERT INTO crashcourse.spittles(id,message,time,latitude,longitude)" +
                "value(:id,:message,:time,:latitude,:longitude)";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("id", spittle.getId());
        paraMap.put("message", spittle.getMessage());
        paraMap.put("time", new java.sql.Date(spittle.getTime().getTime()));
        paraMap.put("latitude", spittle.getLatitude());
        paraMap.put("longitude", spittle.getLongitude());
        namedjdbcOperation.update(sql, paraMap);
    }
//
    public Spittle get(int n) {
        for (int i = 0; i < saves.size(); i++) {
            if (saves.get(i).getId() == n) {
                return saves.get(i);
            }
        }
        return null;
    }
//
//    public Spittle find(long id) {
//        if ((int) id >= spittles.size()) {
//            return null;
//        }
//        return spittles.get((int) id);
//    }
//

    public Spittle find(long id) {
        String sql = "SELECT * FROM crashcourse.spittles WHERE id=?";
//        Spittle[] spittles = new Spittle[100];
        return jdbcOperations.queryForObject(sql,new SpittleRowMapper(),id);
    }

    private static final class SpittleRowMapper implements RowMapper<Spittle> {
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println(new Date());
            return new Spittle(rs.getLong("id"), rs.getString("message"), rs.getDate("time"), rs.getDouble("latitude"), rs.getDouble("longitude"));

        }
    }
    public void add(Spittle spittle) {
        for (Spittle se : spittles) {
            if (se.getId() == spittle.getId()) {
                throw new DuplicateSpittleException("Not Found");
            }

        }
        spittles.add(spittle);
    }
}
