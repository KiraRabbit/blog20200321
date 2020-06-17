//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.kirarabbit.controller;

import com.kirarabbit.common.ResultWrapper;
import com.kirarabbit.entity.User;
import com.kirarabbit.service.UserService;
import com.kirarabbit.utils.encryption;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/login"})
public class LoginController {
    @Autowired
    private UserService userService;

    public LoginController() {
    }

    @RequestMapping(
        value = {"/user"},
        method = {RequestMethod.POST}
    )
    @ResponseBody
    public Object getUser(User user, Map<String, Object> map, HttpSession httpSession) {
        if (!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())) {
            String pwd = encryption.getSHA256(user.getPassword());
            List<User> thisUser = this.userService.getUser(user);
            if (thisUser.size() >= 1) {
                httpSession.setAttribute("userName", user.getUserName());
                httpSession.setAttribute("password", pwd);
                System.out.println("----" + user.getUserName());
                return ResultWrapper.normalResult("");
            } else {
                httpSession.invalidate();
                return ResultWrapper.errorReturn("登录失败");
            }
        } else {
            httpSession.invalidate();
            return ResultWrapper.errorReturn("登录失败");
        }
    }
}
