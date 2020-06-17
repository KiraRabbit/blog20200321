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

    @SneakyThrows
    @RequestMapping(value = "/getMid")
    @ResponseBody
    public Object getMid(HttpServletRequest request) {
        HashMap<Object, Object> map = new HashMap<>();
        logger.error("此次请求的的域名为{}",    request.getServerName());
        logger.error("此次请求的的port为{}",    request.getServerPort());
        logger.error("此次请求的的port为{}",    request.getRequestURL());
        String host = request.getHeader("host");


        InetAddress address= InetAddress.getByName(request.getServerName());
        String hostAddress = address.getHostAddress();
        String hostName = address.getHostName();
        String hostAddress1 = InetAddress.getLocalHost().getHostAddress();
        map.put("域名", request.getServerName());
        map.put("port", request.getServerPort());
        map.put("URL", request.getRequestURL());
        map.put("hostAddress", hostAddress);
        map.put("hostAddress1", hostAddress1);
        map.put("host", host);
        return map;
    }




}
