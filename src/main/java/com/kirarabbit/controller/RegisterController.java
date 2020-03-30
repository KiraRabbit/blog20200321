package com.kirarabbit.controller;

import com.kirarabbit.common.ResultWrapper;
import com.kirarabbit.entity.User;
import com.kirarabbit.service.UserService;
import com.kirarabbit.utils.encryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kira
 */
@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @ResponseBody
    public ModelAndView index() {
        ModelAndView mode = new ModelAndView();
        mode.setViewName("register.html");
        return mode;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public Object insertNewUser(User user) {
        Map<String, Object> map = new HashMap<>();
        String pwd = encryption.getSHA256(user.getPassword());
        user.setPassword(pwd);
        int count = userService.insert(user);
        if (count>0){
            return ResultWrapper.correctReturn("");
        }else {
            return ResultWrapper.errorReturn("注册失败");
        }

    }

}
