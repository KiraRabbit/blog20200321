package com.kirarabbit.dao;

import com.kirarabbit.entity.TblHouse;
import com.kirarabbit.mapper.TblHouseMapper;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TblHouseDao {
    @Autowired
    private TblHouseMapper tblHouseMapper;

    public TblHouseDao() {
    }

    public List<TblHouse> getHouseInfoByPage(Map<String, Object> map) {
        return this.tblHouseMapper.getHouseInfoByPage(map);
    }
}