package com.kirarabbit.dao;

import com.kirarabbit.entity.User;
import com.kirarabbit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
