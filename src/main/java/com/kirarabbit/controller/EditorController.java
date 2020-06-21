package com.kirarabbit.controller;

import com.kirarabbit.entity.Article;
import com.kirarabbit.service.ArticleService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/editor"})
public class EditorController {
    @Autowired
    private ArticleService articleService;

    public EditorController() {
    }

    @RequestMapping(value = {"/insertContent"},method = {RequestMethod.POST})
    @ResponseBody
    public Object insertNewUser(Article article) {
        Map<String, Object> map = new HashMap();
        int num = this.articleService.insert(article);
        if (num > 0) {
            map.put("code", 200);
            map.put("msg", "保存成功");
        } else {
            map.put("code", 400);
            map.put("msg", "保存失败");
        }

        return map;
    }
}