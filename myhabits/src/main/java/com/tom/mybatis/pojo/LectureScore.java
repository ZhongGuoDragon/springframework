package com.tom.mybatis.pojo;

import lombok.Data;

@Data
public class LectureScore {
    private int id;
    private int student_id;
    private Lecture lecture;
    private int score;
}
