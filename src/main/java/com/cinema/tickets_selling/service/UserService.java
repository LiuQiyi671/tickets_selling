package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.User;

public interface UserService extends IService<User> {

    //用户登录
    Boolean loginUser(String username, String password);

    //用户注册
    User registerUser(User user);

    //管理员删除用户
    void removeUser(Long id);

    //用户更新个人信息
    User updateUser(User user);

    //用户获取个人信息
    User showUserInfo(Long id);

    //管理员根据手机号查询某个用户个人信息
    User selectOneUser(String tel);

    //管理员查询所有用户列表
    IPage<User> getUserList(Page p, QueryWrapper queryWrapper);

}
