package com.kirarabbit.controller;

import lombok.SneakyThrows;
import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.HashMap;

/**
 * @author kira
 */
@Controller
@RequestMapping("/firstPage")
public class FirstPageController {
    private static Logger logger = LoggerFactory.getLogger(FirstPageController.class);
    @RequestMapping("")
    public String firstPage() {
        return "firstPage";
    }
}
