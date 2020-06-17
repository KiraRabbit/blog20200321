package com.kirarabbit.entity;

import lombok.Data;

@Data
public class TblHouse {
    private int id;
    private String currentData;
    private String location;
    private String village;
    private int houseType;
    private int money;
    private String orientation;
    private String decorate;
    private int perSquare;
    private String url;
    private int page;
}