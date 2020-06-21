package com.kirarabbit.dao;

import com.kirarabbit.entity.Article;
import com.kirarabbit.mapper.TemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TemplateDao {
    @Autowired
    private TemplateMapper templateMapper;

    public Article getContent(Integer id) {
        return templateMapper.getContent(id);
    }
}
