package com.kirarabbit.service;

import com.kirarabbit.dao.UserDao;
import com.kirarabbit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getUserById(int id) {
        return userDao.getUserById(id);
    }
}
