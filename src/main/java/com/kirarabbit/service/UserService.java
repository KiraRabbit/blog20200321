package com.kirarabbit.service;

import com.kirarabbit.dao.UserDao;
import com.kirarabbit.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private User user;

    public int insert(User user) {
        return userDao.insert(user);

    }

    public List<User> getUser(User user) {
        return userDao.getUser(user);
    }
}
