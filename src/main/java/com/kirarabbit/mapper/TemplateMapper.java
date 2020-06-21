package com.kirarabbit.mapper;

import com.kirarabbit.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TemplateMapper {
    Article getContent(Integer id);
}
