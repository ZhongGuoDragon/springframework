package com.tom.mybatis.mapper;

import com.tom.mybatis.pojo.LectureScore;

import java.util.List;

public interface LectureScoreMapper {
    public List<LectureScore> getLectureScore(int id);
}
