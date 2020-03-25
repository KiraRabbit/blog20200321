package com.kirarabbit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @ResponseBody
    public ModelAndView index(){
        ModelAndView mode = new ModelAndView();
        mode.setViewName("index");
        return mode;
    }
}
