package com.tom.springexcel.mapper;

import com.tom.springexcel.pojo.Original;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public interface OriginalMapper {
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int insertData(Original original);
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public List<Original> selectData(@Param("begin") int begin, @Param("end") int end);
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int insertDataList(List<Original> originals);
}
