package com.kirarabbit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {
    @ResponseBody
    public ModelAndView index(){
        ModelAndView mode = new ModelAndView();
        mode.setViewName("index");
        return mode;
    }
}
