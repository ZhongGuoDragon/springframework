package com.tom.springexcel.web;

import com.tom.springexcel.config.WebConfig;
import com.tom.springexcel.pojo.Format;
import com.tom.springexcel.pojo.Original;
import com.tom.springexcel.tools.ExcelHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(path = "/")
public class ExcelController {
    @Autowired
    Logger logger;
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

    @RequestMapping(method = RequestMethod.POST)
    public String uploadExcel(@RequestPart("files") MultipartFile[] files, HttpServletRequest request) {

        String root = request.getSession().getServletContext().getRealPath("/");
        if (!files[0].getOriginalFilename().toUpperCase().contains(".XL")) {
            return "faile";
        }
        logger.info(root);
        logger.info(files[0].getOriginalFilename());
        ExcelHandler<Original> excelHandler = new ExcelHandler<Original>();
        try {
            excelHandler.readExcelFromHeader(files[0].getInputStream(), new Original());
//            logger.info(excelHandler.toString() + "  " + excelHandler.getExcelDataSize());
            List<Format> list=excelHandler.GetSplitList();
            excelHandler.sendToMysql(list);
            logger.info(list.get(1));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return "index";
    }
}
