package com.kirarabbit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kira
 */
@Controller
@RequestMapping
public class LifeController {

    @ResponseBody
    public ModelAndView index(){
        ModelAndView mode = new ModelAndView();
        mode.setViewName("life.html");
        return mode;
    }
}
