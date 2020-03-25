package com.kirarabbit.controller;

import com.kirarabbit.common.ResultWrapper;
import com.kirarabbit.entity.User;
import com.kirarabbit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kira
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @ResponseBody
    public ModelAndView index(){
        ModelAndView mode = new ModelAndView();
        mode.setViewName("login.html");
        return mode;
    }

    /*@RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Object getAll() {
        List<User> list = userService.getAll();
        return ResultWrapper.correctReturn(list);
    }*/

    /*@RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Object login(String userName,String password) {
        Map<String, Object> map = new HashMap<>();
        List<User> list  =userService.login(userName,password);
        if (list.size()==1){
            map.put("code", 200);
            map.put("msg","登录成功");
        }else{
            map.put("code", 400);
            map.put("msg","登录失败");
        }
        return ResultWrapper.correctReturn(list);
    }*/

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserById(int id) {
        Map<String, Object> map = new HashMap<>();
        List<User> list  =userService.getUserById(id);
        if (list.size()>=1){
            map.put("code", 200);
            map.put("msg","登录成功");
        }else{
            map.put("code", 400);
            map.put("msg","登录失败");
        }
        return ResultWrapper.correctReturn(list);
    }

}
