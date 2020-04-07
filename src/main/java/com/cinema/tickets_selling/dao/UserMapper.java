package com.cinema.tickets_selling.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cinema.tickets_selling.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username = #{username} and password = #{password}")
    Boolean loginUser(String username, String password);
}