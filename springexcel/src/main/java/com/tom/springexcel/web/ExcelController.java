package com.tom.springexcel.web;

import com.tom.springexcel.config.WebConfig;
import com.tom.springexcel.mapper.OriginalMapper;
import com.tom.springexcel.pojo.Format;
import com.tom.springexcel.pojo.Original;
import com.tom.springexcel.tools.ExcelHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;


@Controller
@RequestMapping(path = "/")
public class ExcelController {
    @Autowired
    Logger logger;
    @Autowired
    SqlSession sqlSession;
    @Autowired
    ExcelHandler excelHandler;
    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(HttpServletRequest request) {
//        System.err.println("xxxxxxx");
//        System.out.println("yyyyyyyyyyyyy");
//        logger.error("xxxxx");
//        logger.debug("yyyyy");
//        logger.info("String");
        String root = request.getSession().getServletContext().getRealPath("/");
        logger.info(root);
        return "index";
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String getTest() {
        return "index";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String uploadExcel(@RequestPart("files") MultipartFile[] files, HttpServletRequest request) {
//
//        String root = request.getSession().getServletContext().getRealPath("/");
//        if (!files[0].getOriginalFilename().toUpperCase().contains(".XL")) {
//            return "faile";
//        }
//        logger.info(root);
//        logger.info(files[0].getOriginalFilename());
//        try {
//            excelHandler.readExcelFromHeader(files[0].getInputStream(), new Original());
////            logger.info(excelHandler.toString() + "  " + excelHandler.getExcelDataSize());
//            List<Format> list=excelHandler.GetSplitList();
//            OriginalMapper originalMapper = sqlSession.getMapper(OriginalMapper.class);
//            OutputStream outputStream = new FileOutputStream(new File("/home/tom/xxx.xlsx"));
//            excelHandler.getFormatExcel(list,outputStream);
//            excelHandler.sendToMysql(list);
//            logger.info(list.get(1));
//        } catch (Exception e) {
//
//            try (PrintStream printStream = new PrintStream(new File("/var/log/tomcat9/log4j.log"));) {
//                e.printStackTrace(printStream);
//            } catch (IOException exception) {
//                exception.printStackTrace();
//            }
//
//
//        }
//        return "index";
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<byte[]> uploadExcel(@RequestPart("files") MultipartFile[] files, HttpServletRequest request) {

        String root = request.getSession().getServletContext().getRealPath("/");
        byte[] excelBytes = null;
        HttpHeaders headers = null;
        byte[] outBytes = null;
        if (!files[0].getOriginalFilename().toUpperCase().contains(".XL")) {
            return null;
        }
        try {
            excelHandler.readExcelFromHeader(files[0].getInputStream(), new Original());

//            InputStream is = files[0].getInputStream();
//            excelBytes = new byte[is.available()];
//            is.read(excelBytes);
    //            logger.info(excelHandler.toString() + "  " + excelHandler.getExcelDataSize());
            List<Format> list=excelHandler.GetSplitList();
            OriginalMapper originalMapper = sqlSession.getMapper(OriginalMapper.class);
            OutputStream outputStream = new ByteArrayOutputStream();
            excelHandler.getFormatExcel(list,outputStream);
            ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) outputStream;
            outBytes=byteArrayOutputStream.toByteArray();

            excelHandler.sendToMysql(list);
            //设置httpHeaders,使浏览器响应下载
            headers = new HttpHeaders();
            //告诉浏览器执行下载的操作，“attachment”告诉了浏览器进行下载,下载的文件 文件名为 downloadFileName
            headers.setContentDispositionFormData("attachment",files[0].getOriginalFilename());
            //设置响应方式为二进制，以二进制流传输
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        } catch (Exception e) {

            try (PrintStream printStream = new PrintStream(new File("/var/log/tomcat9/log4j.log"));) {
                e.printStackTrace(printStream);
            } catch (IOException exception) {
                exception.printStackTrace();
            }


        }
        return new ResponseEntity<byte[]>(outBytes, headers, HttpStatus.CREATED);
    }
}
