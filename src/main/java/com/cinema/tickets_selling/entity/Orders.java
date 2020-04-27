package com.cinema.tickets_selling.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("orders")
public class Orders implements Serializable {

    //主键：订单id
    @TableId
    private Integer orderid;

    //用户id
    private Integer userid;

    //排片id
    private Integer scheduleid;

    //下单手机号码
    private String tel;

    //用户下单时间
    private String orderdate;

    //购买电影票数
    private Integer ticketnum;

    //电影票总价
    private BigDecimal tickettotalprice;

    //座位信息
    private String orderseat;

    //手机取票码
    private String phonecode;

//    @TableField(exist = false)
//    private User userentity;
//
//    @TableField(exist = false)
//    private Schedule scheduleentity;
}
