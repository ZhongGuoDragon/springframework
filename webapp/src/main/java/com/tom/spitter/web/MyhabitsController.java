package com.tom.spitter.web;

import com.tom.spitter.db.Spittles;
import com.tom.spitter.db.SpittlesMapper;
import com.tom.spitter.pojo.SpittlesForm;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mybatis")

public class MyhabitsController {
    @Autowired
    SqlSession sqlSession;
    @RequestMapping(path="/form",method = RequestMethod.GET)
    public String getForm() {
        return "form";
    }
    @RequestMapping(path="/getspittles/{hh}",method = RequestMethod.GET)
    public String getSpittlers(Model model,SpittlesForm form) {
        if(form==null){
            return "form";}
        SpittlesMapper mapper=sqlSession.getMapper(SpittlesMapper.class);
        Spittles spittles=mapper.getSpittles(1);
        model.addAttribute("spittle", spittles);
        return "result";
    }
}
