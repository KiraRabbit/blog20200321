package com.kirarabbit.entity.VO;

import lombok.Data;

@Data
public class TblHouseVO {
    private int id;
    private String currentData;
    private String location;
    private String village;
    private String houseType;
    private String orientation;
    private String decorate;
    private int perSquare;
    private String houseTypeLess;
    private String houseTypeMore;
    private String moneyLess;
    private String moneyMore;
}