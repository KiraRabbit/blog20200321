package com.kirarabbit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class IndexController {
    @GetMapping("index")
    public String index() {
        return "/index";
    }

    @GetMapping("firstPage")
    public String firstPage() {
        return "/firstPage";
    }
    @GetMapping("editor")
    public String editor() {
        return "/editor";
    }
    @GetMapping("aboutMe")
    public String aboutMe() {
        return "/aboutMe";
    }
    @GetMapping("life")
    public String life() {
        return "/life";
    }
    @GetMapping("manager")
    public String manager() {
        return "/manager";
    }
    @GetMapping("reward")
    public String reward() {
        return "/reward";
    }
    @GetMapping("technology")
    public String technology() {
        return "/technology";
    }
    @GetMapping("update")
    public String update() {
        return "/update";
    }
    @GetMapping("404")
    public String noFound() {
        return "/404";
    }
    @GetMapping("tags")
    public String tags() {
        return "/tags";
    }
    @GetMapping("article")
    public String article() {
        return "/article";
    }

}
