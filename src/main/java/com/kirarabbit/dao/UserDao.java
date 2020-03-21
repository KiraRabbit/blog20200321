package com.kirarabbit.dao;

import com.kirarabbit.entity.User;
import com.kirarabbit.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-22 03:15:26
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAll() {
        return userMapper.getAll();
    }
}