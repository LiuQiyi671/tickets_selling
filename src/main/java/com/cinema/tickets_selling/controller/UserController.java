package com.cinema.tickets_selling.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cinema.tickets_selling.entity.User;
import com.cinema.tickets_selling.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


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
    public User loginUser(@RequestBody User user){
        return userService.loginUser(user.getUsername(), user.getPassword());
    }

    @ApiOperation("管理员根据用户id删除用户")
    @PostMapping("/admin/delete_user")
    public Boolean deleteUser(@RequestParam("id") Integer id){
        userService.removeUser(id);
        return true;
    }

    @ApiOperation("用户根据用户id修改用户信息")
    @PostMapping("/user/update")
    public Boolean updateUser(@RequestParam("userid") Integer userid,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("tel") String tel,
                              @RequestParam("email") String email,
                              @RequestParam("gender") String gender,
                              @RequestParam("money") BigDecimal money){
        User user = new User();
        user.setUserid(userid);
        user.setUsername(username);
        user.setPassword(password);
        user.setTel(tel);
        user.setEmail(email);
        user.setGender(gender);
        user.setMoney(money);
        userService.updateUser(user);
        return true;
    }

    @ApiOperation("用户根据用户id获取用户信息")
    @GetMapping("/user/user_info")
    public User showUserInfo(@RequestParam("id") Integer id){
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