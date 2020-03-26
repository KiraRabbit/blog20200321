package com.kirarabbit.mapper;

import com.kirarabbit.baseMapper.TkMapper;
import com.kirarabbit.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

   // List<User> getUserById(int id);

    int insert(User user);

    List<User> getUser(User user);
}
