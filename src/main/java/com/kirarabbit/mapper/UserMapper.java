package com.kirarabbit.mapper;

import com.kirarabbit.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAll();

}
