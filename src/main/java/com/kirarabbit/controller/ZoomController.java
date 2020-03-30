package com.kirarabbit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zoom")
public class ZoomController {


    @GetMapping("login")
    public String login() {
        return "/zoom/login";
    }

    @GetMapping("register")
    public String register() {
        return "/zoom/register";
    }
    @GetMapping("charts")
    public String charts() {
        return "/zoom/charts";
    }
    @GetMapping("forms")
    public String forms() {
        return "/zoom/forms";
    }
    @GetMapping("index")
    public String index() {
        return "/zoom/index";
    }
    @GetMapping("tables")
    public String tables() {
        return "/zoom/tables";
    }

    @GetMapping("firstPage")
    public String firstPage() {
        return "/zoom/firstPage";
    }

}
