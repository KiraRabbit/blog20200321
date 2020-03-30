package com.kirarabbit.service;

import com.kirarabbit.dao.ArticleDao;
import com.kirarabbit.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public int insert(Article article) {
        if (article.getCreateTime()==null){
            article.setCreateTime(new Date());
            return articleDao.insert(article);
        }
        return articleDao.insert(article);
    }
}
