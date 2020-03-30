package com.kirarabbit.controller;

import com.kirarabbit.common.ResultWrapper;
import com.kirarabbit.entity.User;
import com.kirarabbit.service.UserService;
import com.kirarabbit.utils.encryption;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Object getUser(User user, Map<String, Object> map,HttpSession httpSession) {
        //验证用户名和密码，输入正确，跳转到dashboard
        if (!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())) {
            String pwd = encryption.getSHA256(user.getPassword());
            List<User> thisUser = userService.getUser(user);
            if (thisUser.size()>=1){
                httpSession.setAttribute("userName", user.getUserName());
                httpSession.setAttribute("password", pwd);
                System.out.println("----" + user.getUserName());
                return ResultWrapper.correctReturn("");
            }else {
                //输入错误，清空session，提示用户名密码错误
                httpSession.invalidate();
                return ResultWrapper.errorReturn("登录失败");
            }
        } else {
            //输入错误，清空session，提示用户名密码错误
            httpSession.invalidate();
            return ResultWrapper.errorReturn("登录失败");
        }

    }
}




