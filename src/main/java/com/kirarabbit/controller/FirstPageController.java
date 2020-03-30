package com.kirarabbit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kira
 */
@Controller
@RequestMapping("/firstPage")
public class FirstPageController {
    @RequestMapping("")
    public String firstPage() {
        return "firstPage";
    }

}
