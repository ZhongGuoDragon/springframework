package com.tom.mybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private long id;
    private String text;
    private Date time;
    private Sex sex;

    public Role(Long id, String text, Date time, Sex sex) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.sex = sex;
    }

    public String toString() {
        return id +" "+ text+" " + time+" " + sex;
    }


}
