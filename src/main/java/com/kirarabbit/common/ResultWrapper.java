package com.kirarabbit.common;

import com.kirarabbit.mybatis.PageContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于返回格式化的json信息
 *
 * @author kira 2015-09-08
 */
public class ResultWrapper {

    public static Map<String, Object> correctReturn(Object ret) {
        if (PageContext.getPage() != null) {
            return pageResult(ret);
        }
        return normalResult(ret);
    }

    public static Map<String, Object> errorReturn(int errcode, String errmsg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", errcode);
        map.put("msg", errmsg);
        return map;
    }

    public static Map<String, Object> errorReturn(String errmsg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("msg", errmsg);
        return map;
    }

    public static Map<String, Object> defaultResult(boolean success) {
        if (success) {
            return correctReturn("操作成功");
        } else {
            return errorReturn("操作失败");
        }
    }

    public static Map<String, Object> normalResult(Object ret) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "");
        map.put("result", ret);
        return map;
    }

    private static Map<String, Object> pageResult(Object ret) {
        Map<String, Object> result = new HashMap<>();
        result.put("items", ret);
        result.put("total", PageContext.getPage().getTotalRows());
        return normalResult(result);
    }
    public static Map<String, Object> layuiResult(Object ret, int size) {
        Map<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", ret);
        return map;
    }
}
