package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.User;

public interface UserService extends IService<User> {

    Boolean loginUser(String username, String password);

    User registerUser(User user);

    void removeUser(Long id);

    User updateUser(User user);

    User showUserInfo(Long id);

    User selectOneUser(String tel);

    IPage<User> getUserList(Page p, QueryWrapper queryWrapper);

}
