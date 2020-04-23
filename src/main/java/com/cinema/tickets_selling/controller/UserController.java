package com.cinema.tickets_selling.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cinema.tickets_selling.entity.User;
import com.cinema.tickets_selling.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
@Api
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @ApiOperation("用户注册")
    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user)
    {
        return userService.registerUser(user);
    }

    @ApiOperation("用户登录")
    @PostMapping("/user/login")
    public Boolean loginUser(@RequestBody User user){
        return userService.loginUser(user.getUsername(), user.getPassword());
    }

    @ApiOperation("管理员根据用户id删除用户")
    @PostMapping("/admin/delete_user")
    public Boolean deleteUser(@RequestParam("id") Long id){
        userService.removeUser(id);
        return true;
    }

    @ApiOperation("用户根据用户id修改用户信息")
    @PostMapping("/user/update/{id}")
    public Boolean updateUser(@PathVariable("id") User user){
        userService.updateUser(user);
        return true;
    }

    @ApiOperation("用户根据用户id获取用户信息")
    @GetMapping("/user/user_info")
    public User showUserInfo(@RequestParam("id") Long id){
        return userService.showUserInfo(id);
    }

    @ApiOperation("管理员查询所有用户列表")
    @GetMapping("/admin/user_list/{page}")
    public IPage<User> getUserList(@PathVariable("page") int page){

        Page<User> p = new Page<User>(page,5);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("userid", 0);

        return userService.getUserList(p,queryWrapper);
    }


    @ApiOperation("管理员根据手机号码查询用户信息")
    @GetMapping("/admin/get_one_user")
    public User getOneUser(@RequestParam("tel") String tel){
        return userService.selectOneUser(tel);
    }



}