package com.tom.springexcel.mapper;

import com.tom.springexcel.pojo.Original;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Configuration
//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public interface OriginalMapper {
    public int insertData(Original original);
    public List<Original> selectData(@Param("begin") int begin, @Param("end") int end);
    public int insertDataList(List<Original> originals);
}
