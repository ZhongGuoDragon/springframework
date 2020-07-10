package com.tom.spitter.web;

import com.tom.spitter.Spittle;
import com.tom.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spit) {
        this.spittleRepository = spit;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(5, 5));
        return "spittles";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/a"})
    public String a(Model model) {
        model.addAttribute("spittleList", spittleRepository.findSpittles(10, 10));
        return "spittles";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/b"})
    public String b(Map model) {
        model.put("spittleList", spittleRepository.findSpittles(20, 20));
        return "spittles";
    }
    @RequestMapping(method=RequestMethod.GET,path={"/c"})
    public List<Spittle> c() {
        return spittleRepository.findSpittles(30, 30);
    }
}
