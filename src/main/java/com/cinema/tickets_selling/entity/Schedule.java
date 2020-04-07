package com.cinema.tickets_selling.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("schedule")
public class Schedule implements Serializable {
    //主键：排片id
    @TableId
    private Long scheduleid;

    //电影名称
    private String moviename;

    //订票用户
    private String username;

    //订票数量
    private Integer ticketnumber;
}