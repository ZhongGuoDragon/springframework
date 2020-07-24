package com.tom.spitter.web;

import com.tom.spitter.Spittle;
import com.tom.spitter.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository<Spittle> spittleRepository;
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
        model.addAttribute("spittleList", spittleRepository.findSpittles(0, 10));
        return "spittles";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/b"})
    public String b(Map model) {
        model.put("spittleList", spittleRepository.findSpittles(0, 20));
        return "spittles";
    }
//    @RequestMapping(method=RequestMethod.GET)
//    public List<Spittle> c() {
//        return spittleRepository.findSpittles(30, 30);
//    }

    @RequestMapping(method = RequestMethod.GET, path = {"/show"})
    public String showSpittle(@RequestParam(value = "max", defaultValue = "0") long max,
                              @RequestParam(value = "count", defaultValue = "20") int count, Model model) {
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";

    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = "0") long max,
//                                  @RequestParam(value = "count", defaultValue = "20") int count) {
//        return spittleRepository.findSpittles(max, count);
//    }

    //    @RequestMapping(method =RequestMethod.GET,value="/{spittleid}")
//    public String spittles(@PathVariable("spittleid") int spittleid,Model model){
//        model.addAttribute(spittleRepository.findSpittles(0, spittleid));
//        return "spittles";
//    }
    @RequestMapping(method = RequestMethod.GET, path = "/view/{spittleid}")
    public String spittlespath(@PathVariable int spittleid, Model model) {
        model.addAttribute(spittleRepository.findSpittles(0, spittleid));

        return "spittles";
    }

//    @RequestMapping(value = "/{spittle}", method = RequestMethod.GET)
//    public String spittle(@PathVariable int spittle) {
//        return "123";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> doSpittle(@RequestParam(value = "i") int i) {
        System.out.println(i);
        return spittleRepository.findSpittles(i, 20);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public String doRegister() {
        return "registerForm";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public String saveRegister(@Valid Spittle spittle, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
//        System.out.println("saveRegister");
//        System.out.println(spittle.getId());
        spittleRepository.save(spittle);
//        return "index";
        return "redirect:/spittles/" + spittle.getId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String doResult(@PathVariable int id, Model model) {

        model.addAttribute("spittle", spittleRepository.find(id));
        return "result";

    }

    @RequestMapping(method = RequestMethod.GET, path = "/sign")
    public String doSign(Model model) {
        model.addAttribute(new Spittle(0, null, null, null, null));
        return "sign";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/sign")
    public String postSign(@Validated Spittle spittle, Errors errors) {
        if (errors.hasErrors()) {
            return "sign";
        }
//        model.addAttribute(spittle);
        System.out.println(spittle.getMessage());
        return "result";
    }

    @RequestMapping(path = "/mul/{add}", method = RequestMethod.GET)
    public String doAdd(@PathVariable String add) {
        return add;
    }

    @RequestMapping(path = "/mul/upload", method = RequestMethod.POST)
    public String doUpload(@RequestPart("profilePicture") byte[] part, @RequestPart("files") MultipartFile[] files, HttpServletRequest request) {
        try {
            String path = request.getSession().getServletContext().getRealPath("/") + "upload" + files[0].getOriginalFilename();
            files[0].transferTo(new File(path));
            System.out.println(path);
            path = request.getSession().getServletContext().getRealPath("/") + "upload" + files[1].getOriginalFilename();
            files[1].transferTo(new File(path));
        } catch (Exception exception) {

        }
        System.out.println(new String(part));
        System.out.println("doupload");
        System.out.println(request.getParameter("name"));
        return "upload";
    }

    @RequestMapping(path = "/{first}/{second}/upload", method = RequestMethod.GET)
    public String doFirstSecond(@PathVariable("first") String first, @PathVariable("second") String second, Model model) {
        model.addAttribute(first, first);
        model.addAttribute(second, second);
        return "fs";
    }

    @RequestMapping(path = "/find/{id}", method = RequestMethod.GET)
    public String doFind(@PathVariable long id, Model model) {
        if (spittleRepository.find(id) == null) {
            throw new spittleNotFoundException();
        }
        model.addAttribute(spittleRepository.find(id));
        return "result";
    }

    @RequestMapping(path = "/save", method = RequestMethod.GET)
    public String doSave() {
        return "save";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String savePost(Spittle spittle, RedirectAttributes model) {
        model.addFlashAttribute(spittle);
        return "redirect:/spittles/saves";
//        long id = spittle.getId();
//        String name = spittle.getMessage();
//        model.addAttribute("id", id);
//        model.addAttribute("name", name);
//        return "redirect:/spittles/{id}";
//        spittleRepository.add(spittle);
//        return "result";
    }

    @RequestMapping(path = "/saves", method = RequestMethod.GET)
    public String saves() {
        System.out.println("saves");
        return "result";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginsuccess() {
        return "result";
    }
//    @ExceptionHandler(DuplicateSpittleException.class)
//    public String wrong(Throwable e,Model model) {
//        model.addAttribute("she", e);
//        System.out.println(e.getMessage());
//        return "wrong";
//    }

    @RequestMapping(path = "/get/ip", method = RequestMethod.GET)
    public String ip(HttpServletRequest request) {
        String s = request.getRemoteAddr();
        System.out.println(s);
        return null;
    }
}
