package com.tom.springexcel.mapper;

import com.tom.springexcel.pojo.Format;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormatMapper {
    public int insertData(Format format);
    public int insertDataList(List<Format> list);
    public List<Format> selectData(@Param("begin") int begin, @Param("end") int end);


}
