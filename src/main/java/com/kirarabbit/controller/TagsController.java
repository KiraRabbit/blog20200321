//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.kirarabbit.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kirarabbit.common.ResultWrapper;
import com.kirarabbit.entity.TblHouse;
import com.kirarabbit.entity.VO.TblHouseVO;
import com.kirarabbit.service.TblHouseService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/tags"})
public class TagsController {
    @Autowired
    private TblHouseService tblHouseService;

    public TagsController() {
    }

    @RequestMapping(
        value = {"/getHouseInfo"},
        method = {RequestMethod.GET}
    )
    @ResponseBody
    public Object insertNewUser(TblHouseVO tblHouse, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        PageInfo<TblHouse> listPage = new PageInfo(this.tblHouseService.getHouseInfoByPage(tblHouse));
        Map<String, Object> stringObjectHashMap = ResultWrapper.layuiResult(listPage.getList(), (int)listPage.getTotal());
        return stringObjectHashMap;
    }
}
