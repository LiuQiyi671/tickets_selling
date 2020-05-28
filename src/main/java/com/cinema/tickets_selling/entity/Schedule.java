package com.cinema.tickets_selling.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("schedule")
public class Schedule implements Serializable {
    //主键：场次id
    @TableId
    private Integer scheduleid;

    //影片id
    private Integer movieid;

    //影厅名称
    private String hallname;

    //放映日期
    private String showdate;

    //放映时间
    private String showtime;

    //影片单价
    private BigDecimal price;

    //场次座位信息
    private String seat;

//    @TableField(exist = false)
//    private Movie movieentity;

}