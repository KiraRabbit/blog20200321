package com.kirarabbit.mapper;

import com.kirarabbit.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TemplateMapper {
    Article getContent(Integer id);

    List<Article> getAll();
}
