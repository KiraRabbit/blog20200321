package com.kirarabbit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kira
 */
@Controller
@RequestMapping("/firstPage")
public class firstPageController {

    @RequestMapping("/list")
    public String firstPage(Model model) {
        return "firstPage/list";
    }
}
