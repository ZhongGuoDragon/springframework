package com.tom.mybatis.pojo;

import lombok.Data;

@Data
public class HealthMale implements Health{
    private int id;
    private int student_id;
    private String prostate;
}
