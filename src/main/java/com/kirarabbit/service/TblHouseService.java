//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.kirarabbit.service;

import com.kirarabbit.dao.TblHouseDao;
import com.kirarabbit.entity.TblHouse;
import com.kirarabbit.entity.VO.TblHouseVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TblHouseService {
    @Autowired
    private TblHouseDao tblHouseDao;


    public List<TblHouse> getHouseInfoByPage(TblHouseVO tblHouse) {
        Map<String, Object> map = new HashMap();
        if (!StringUtils.isEmpty(tblHouse.getLocation())) {
            map.put("location", tblHouse.getLocation());
        }

        if (!StringUtils.isEmpty(tblHouse.getHouseTypeLess())) {
            map.put("houseTypeLess", tblHouse.getHouseTypeLess());
        }

        if (!StringUtils.isEmpty(tblHouse.getHouseTypeMore())) {
            map.put("houseTypeMore", tblHouse.getHouseTypeMore());
        }

        if (!StringUtils.isEmpty(tblHouse.getMoneyLess())) {
            map.put("moneyLess", tblHouse.getMoneyLess());
        }

        if (!StringUtils.isEmpty(tblHouse.getMoneyMore())) {
            map.put("moneyMore", tblHouse.getMoneyMore());
        }

        return this.tblHouseDao.getHouseInfoByPage(map);
    }
}
