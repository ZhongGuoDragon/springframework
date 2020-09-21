package com.tom.springexcel;

import com.tom.springexcel.config.SqlSessionBuilder;
import com.tom.springexcel.config.WebAppInitializer;
import com.tom.springexcel.config.WebConfig;
import com.tom.springexcel.mapper.FormatMapper;
import com.tom.springexcel.mapper.OriginalMapper;
import com.tom.springexcel.pojo.Format;
import com.tom.springexcel.pojo.Original;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.FormattedFloatingDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SqlSessionBuilder.class})
public class ExcelTest {
    @Autowired
    SqlSession sqlSession;



    @Test
    public void Test() {

    }


    public void Test1() {
        Original original = new Original("caonima", new Date());
        List<Original> list = new ArrayList<Original>();
        list.add(original);
        list.add(original);
        list.add(original);
        OriginalMapper mapper= sqlSession.getMapper(OriginalMapper.class);
        mapper.insertDataList(list);
//        sqlSession.commit();
        System.out.println(mapper.selectData(0, 2));
    }

    public void Test3() {
        Format format = new Format("xt","zh", "mm", "grwz", "sr", "hys", "ipdz", "zcsj", "zhhc", new Date());
        FormatMapper mapper = sqlSession.getMapper(FormatMapper.class);
        List<Format> list = new ArrayList<Format>();
        mapper.insertDataList(list);
        System.out.println(mapper.selectData(0, 10));
    }
}
