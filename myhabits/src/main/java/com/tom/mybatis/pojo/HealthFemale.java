package com.tom.mybatis.pojo;

import lombok.Data;

@Data
public class HealthFemale implements Health{
    private int id;
    private int student_id;
    private String check_date;
    private String heart;
    private String uterus;
}
