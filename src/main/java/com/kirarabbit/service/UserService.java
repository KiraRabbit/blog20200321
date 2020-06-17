//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.kirarabbit.service;

import com.kirarabbit.dao.UserDao;
import com.kirarabbit.entity.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDao;

    public int insert(User user) {
        return this.userDao.insert(user);
    }

    public List<User> getUser(User user) {
        return this.userDao.getUser(user);
    }
}
