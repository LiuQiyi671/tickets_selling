package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.tickets_selling.dao.UserMapper;
import com.cinema.tickets_selling.entity.User;
import com.cinema.tickets_selling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Boolean loginUser(String username, String password) {
        return userMapper.loginUser(username, password) != null;
    }

    @Override
    public User registerUser(User user) {
        int rows = userMapper.insert(user);
        if (rows == 1) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void removeUser(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        int rows = userMapper.updateById(user);
        if (rows == 1) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User showUserInfo(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User selectOneUser(String tel) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tel",tel);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<User> getUserList(Page p,QueryWrapper queryWrapper) throws RuntimeException {
        try {
            IPage<User> iPage = userMapper.selectPage(p,queryWrapper);
            return iPage;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
