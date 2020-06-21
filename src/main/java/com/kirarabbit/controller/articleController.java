package com.kirarabbit.controller;

import com.kirarabbit.common.ResultWrapper;
import com.kirarabbit.entity.Article;
import com.kirarabbit.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author kira
 */
@Controller
@RequestMapping("/article")
public class articleController {
    @Autowired
    private TemplateService templateService;

    @RequestMapping(value = "/getContent", method = RequestMethod.GET)
    @ResponseBody
    public Object getContent(Integer id) {
        Article content = templateService.getContent(id);
        return ResultWrapper.correctReturn(content);
    }

}
