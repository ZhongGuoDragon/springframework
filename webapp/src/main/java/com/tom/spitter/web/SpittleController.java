package com.tom.spitter.web;

import com.tom.spitter.Spittle;
import com.tom.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;
    private static final String MAX = "99999999999";

    @Autowired
    public SpittleController(SpittleRepository spit) {
        this.spittleRepository = spit;
    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute(spittleRepository.findSpittles(5, 5));
//        return "spittles";
//    }

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
//    @RequestMapping(method=RequestMethod.GET)
//    public List<Spittle> c() {
//        return spittleRepository.findSpittles(30, 30);
//    }

    @RequestMapping(method = RequestMethod.GET, path = {"/show"})
    public String showSpittle(@RequestParam(value = "max", defaultValue = "0") long max,
                              @RequestParam(value = "count", defaultValue = "20") int count,Model model) {
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = "0") long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

//    @RequestMapping(method =RequestMethod.GET,value="/{spittleid}")
//    public String spittles(@PathVariable("spittleid") int spittleid,Model model){
//        model.addAttribute(spittleRepository.findSpittles(0, spittleid));
//        return "spittles";
//    }
    @RequestMapping(method =RequestMethod.GET,path="/view")
    public String spittlespath(@PathVariable("spittleid") int spittleid,Model model){
        model.addAttribute(spittleRepository.findSpittles(0, spittleid));
        return "spittles";
    }

    @RequestMapping(value = "/{spittle}", method = RequestMethod.GET)
    public String spittle(@PathVariable int spittle) {
        return "123";
    }

}
