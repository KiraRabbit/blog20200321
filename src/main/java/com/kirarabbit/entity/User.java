package com.kirarabbit.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User  {
    private Integer id;
    private String phone;
    private String userName;
    private String password;
    private String gender;
    private String trueName;
    private String birthday;
    private String email;
    private Date createTime;
    private Date modifyTime;
}