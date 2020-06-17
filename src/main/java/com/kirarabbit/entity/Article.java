package com.kirarabbit.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Article  {
    private Integer id;
    private String articleName;
    private String content;
    private String author;
    private String classify;
    private Date createTime;
    private Date modifyTime;
}