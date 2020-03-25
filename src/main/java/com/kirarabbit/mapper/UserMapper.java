package com.kirarabbit.mapper;

import com.kirarabbit.baseMapper.TkMapper;
import com.kirarabbit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface UserMapper  {

    List<User> getUserById(int id);
}
