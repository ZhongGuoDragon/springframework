package com.tom.mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String cnname;
    private Sex sex;
    private List<StudentCard> studentCard;
    private List<LectureScore> lectureScores;
    private Health health;
//    private HealthFemale healthFemale;
//    private HealthMale healthMale;
}
