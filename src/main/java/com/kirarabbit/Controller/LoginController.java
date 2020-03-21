package com.kirarabbit.Controller;

import com.kirarabbit.common.ResultWrapper;
import com.kirarabbit.entity.User;
import com.kirarabbit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Object getAll() {

        List<User> list = userService.getAll();
        return ResultWrapper.correctReturn(list);
    }

}
