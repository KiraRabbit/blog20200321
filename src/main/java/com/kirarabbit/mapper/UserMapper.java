package com.kirarabbit.mapper;

import com.kirarabbit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAll();

    List<User> getOne(@Param("userName")String userName,@Param("password") String password);

}
