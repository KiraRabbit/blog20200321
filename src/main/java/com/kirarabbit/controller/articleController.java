package com.kirarabbit.controller;

import com.kirarabbit.common.ResultWrapper;
import com.kirarabbit.entity.Article;
import com.kirarabbit.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Object getContent( @RequestParam String id) {
        Article content = templateService.getContent(Integer.valueOf(id));
        return ResultWrapper.correctReturn(content);
    }

    @RequestMapping(value = "/getContentInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object getContentInfo(@RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "4") int size ) {
        List<Article> contentInfoList = templateService.getContentInfo(page,size);
        return ResultWrapper.correctReturn(contentInfoList);
    }

}
