package com.kirarabbit.dao;

import com.kirarabbit.entity.Article;
import com.kirarabbit.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {
    @Autowired
    private ArticleMapper articleMapper;

    public ArticleDao() {
    }

    public int insert(Article article) {
        return this.articleMapper.insert(article);
    }
}