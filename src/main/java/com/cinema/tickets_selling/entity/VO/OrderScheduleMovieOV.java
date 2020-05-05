package com.cinema.tickets_selling.entity.VO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderScheduleMovieOV implements Serializable {

    //订单id
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

    //影片名称
    private String moviename;

}
