package com.kirarabbit.controller;

import com.kirarabbit.common.ResultWrapper;
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
@RequestMapping("/template")
public class templateController {
    @Autowired
    private TemplateService templateService;

    @RequestMapping(value = "/getContent", method = RequestMethod.GET)
    @ResponseBody
    public Object getContent(Integer id) {
        return ResultWrapper.correctReturn(templateService.getContent(id));
    }

}
