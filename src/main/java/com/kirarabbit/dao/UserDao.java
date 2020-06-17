package com.kirarabbit.dao;

import com.kirarabbit.entity.User;
import com.kirarabbit.mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public UserDao() {
    }

    public int insert(User user) {
        return this.userMapper.insert(user);
    }

    public List<User> getUser(User user) {
        return this.userMapper.getUser(user);
    }
}