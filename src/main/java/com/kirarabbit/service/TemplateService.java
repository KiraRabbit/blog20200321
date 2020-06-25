package com.kirarabbit.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kirarabbit.dao.TemplateDao;
import com.kirarabbit.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
    @Autowired
    private TemplateDao templateDao;
    public Article getContent(Integer id) {
        return templateDao.getContent(id);
    }

    public List<Article> getContentInfo(int page, int size) {
        //紧跟着改行代码的第一条查询会被分页。
        PageHelper.startPage(page,size);

        List<Article> list = templateDao.getAll();
        for (Article article : list) {
            String[] split = article.getContent().split("```");
            String content = split[0].replace("#", "").replace("\n", "。");
          if (content.length()>512){
              content = content.substring(0, 512);
          }
            article.setContent(content+"...");
        }

        //创建分页信息对象，通过该对象可以获取总记录数和分页信息等数据
//        PageInfo<Article> pageInfo = new PageInfo<Article>(list);
//
//        PageBean<Article> pageBean = new PageBean<>();
//        pageBean.setCurPage(page);//设置当前页
//        pageBean.setCount((int) pageInfo.getTotal());//设置总记录数
//        pageBean.setPageSize(size);//设置页面大小
//        pageBean.setData(pageInfo.getList());//设置个人收藏路线数据

        return list;
    }
}
