package com.kirarabbit.mapper;

import com.kirarabbit.entity.TblHouse;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblHouseMapper {
    List<TblHouse> getHouseInfoByPage(Map<String, Object> map);
}