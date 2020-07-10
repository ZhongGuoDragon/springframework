package com.tom.spitter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
    @RequestMapping(value = "/123", method = RequestMethod.GET)
    public String hh() {
        return "123";
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String hhh() {
        return "home";
    }

}
