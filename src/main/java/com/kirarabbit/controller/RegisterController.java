package com.kirarabbit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kira
 */
@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {

    @ResponseBody
    public ModelAndView index() {
        ModelAndView mode = new ModelAndView();
        mode.setViewName("register.html");
        return mode;
    }



}
