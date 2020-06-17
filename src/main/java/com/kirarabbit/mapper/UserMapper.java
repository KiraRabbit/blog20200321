package com.kirarabbit.mapper;

import com.kirarabbit.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User user);

    List<User> getUser(User user);
}
