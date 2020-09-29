package com.tom.springexcel.tools;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.tom.springexcel.config.WebAppInitializer;
import com.tom.springexcel.mapper.FormatMapper;
import com.tom.springexcel.pojo.Format;
import com.tom.springexcel.pojo.Original;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
@Service
public class ExcelHandler<T> {

    @Autowired
    private SqlSession sqlSession;
    //    @Autowired
//    private FormatMapper formatMapper;
//    @Autowired
//    MapperFactoryBean mapperFactoryBean;
    @Autowired
    Logger logger;
    //    private static final int BATCH_COUNT = 100;
    private List<Object> excelData;
    private List<Format> formatList;
    private final static String string = "[\\u4e00-\\u9fa5]";

//    private static Logger logger = Logger.getLogger(ExcelHandler.class);


    public ExcelHandler() {

    }

    @Override
    public String toString() {
        return excelData.toString();
    }

    public int getExcelDataSize() {
        return this.excelData.size();
    }

    public void readExcelFromHeader(InputStream inputStream, T t) {
        AnalysisEventListener listener = new ExcelListerner<T>();
        ExcelReader excelReader = EasyExcel.read(inputStream, t.getClass(), listener).build();
        ReadSheet readSheet = EasyExcel.readSheet("Sheet1").headRowNumber(Integer.valueOf(0)).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

    class ExcelListerner<T> extends AnalysisEventListener<T> {

        private List<T> list = new ArrayList<T>();

        @Override
        public void invoke(T t, AnalysisContext analysisContext) {

            list.add(t);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            excelData = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Original original = (Original) list.get(i);
                if (!(original.getData() == null)) {
                    ExcelHandler.this.excelData.add(original);
                }
            }
        }
    }

    public List<Format> GetSplitList() {
        formatList = new ArrayList<>();

        for (int i = 0; i < excelData.size(); i++) {
            Format format = new Format();
            Original original = (Original) excelData.get(i);

//            format.setZh(doRegex("账号", "密码", original));
//            format.setMm(doRegex("密码", "个人网址", original));
//            format.setGrwz(doRegex("个人网址", "生日", original));
//            format.setSr(doRegex("生日", "好友数", original));
//            format.setHys(doRegex("好友数", "IP地址", original));
//            format.setIpdz(doRegex("IP地址", "常用位置", original));
//            format.setCywz(doRegex("常用位置", "注册时间", original));
//            format.setZcsj(doRegex("注册时间", "账号缓存", original));
//            format.setZhhc(doRegex("账号缓存", "", original));
            format.setZh(doRegex("账号", ".+?",string+"+：", original));
            format.setMm(doRegex("密码", ".+?",string+"+：", original));
            format.setGrwz(doRegex("个人网址", ".+?",string+"+：", original).replaceAll("IP",""));
            format.setSr(doRegex("生日", ".+?",string+"+：", original).replaceAll("IP",""));
            format.setHys(doRegex("好友数", ".+?","IP地址|"+string+"+：", original).replaceAll("IP",""));
            format.setIpdz(doRegex("IP地址", ".+?",string+"+：", original));
            format.setCywz(doRegex("常用位置", ".+?",string+"+：", original));
            format.setZcsj(doRegex("注册时间", ".+?",string+"+：", original));
            format.setZhhc(doRegex("账号缓存", ".+","", original));
//            logger.error(format);
            formatList.add(format);
        }
        return formatList;
    }


    public int sendToMysql(List<Format> list) {
//        logger.info(sqlSession == null);
        FormatMapper formatMapper = sqlSession.getMapper(FormatMapper.class);
        int m = formatMapper.insertDataList(list);
        return m;
    }

    public void getFormatExcel(List<Format> list,OutputStream outputStream) {
        EasyExcel.write(outputStream, Format.class).sheet(2, "账号数据").doWrite(list);
    }
    static String doRegex(String begin, String middle,String end, Original original) {
//        String stringReg = begin + ".+?" + end;
//        Pattern pattern1 = Pattern.compile(stringReg);
//        Matcher matcher=pattern1.matcher(original.getData());
//        if (matcher.find()) {
//            String string = matcher.group(0);
//            string=string.substring(begin.length()+1, string.length()-end.length());
//            return string;
//        } else {
//            return "";
//        }
        String stringReg = "(" + begin + "：)" + "("+middle+")" + "(" + end + ")";
        Pattern pattern1 = Pattern.compile(stringReg);
        Matcher matcher = pattern1.matcher(original.getData());
        if (matcher.find()) {
            String string = matcher.group(2);
//            string=string.substring(begin.length()+1, string.length()-end.length());
            return string;
        } else {
            return "";
        }
    }
}
