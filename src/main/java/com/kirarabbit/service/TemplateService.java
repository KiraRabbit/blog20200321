package com.kirarabbit.service;

import com.kirarabbit.dao.TemplateDao;
import com.kirarabbit.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {
    @Autowired
    private TemplateDao templateDao;
    public Article getContent(Integer id) {
        return templateDao.getContent(id);
    }
}
