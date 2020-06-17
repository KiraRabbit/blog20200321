//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.kirarabbit.service;

import com.kirarabbit.dao.ArticleDao;
import com.kirarabbit.entity.Article;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public int insert(Article article) {
        if (article.getCreateTime() == null) {
            article.setCreateTime(new Date());
            return this.articleDao.insert(article);
        } else {
            return this.articleDao.insert(article);
        }
    }
}
