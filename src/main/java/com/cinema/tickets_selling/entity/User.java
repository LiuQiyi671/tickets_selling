package com.cinema.tickets_selling.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("user")
public class User implements Serializable {
    //主键：用户id
    @TableId
    private Integer userid;

    //用户名
    private String username;

    //用户密码
    private String password;

    //用户手机号码
    private String tel;

    //用户电子邮箱
    private String email;

    //用户性别
    private String gender;

    //用户账户余额
    private BigDecimal money;

}
