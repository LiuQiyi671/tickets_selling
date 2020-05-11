package com.cinema.tickets_selling.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cinema.tickets_selling.entity.Orders;
import com.cinema.tickets_selling.entity.VO.OrderScheduleMovieOV;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("select t1.*,t2.movieid,t2.hallname,t2.showdate,t2.showtime,t2.price,t2.seat,t3.moviename from orders t1 LEFT JOIN schedule t2 ON t1.scheduleid = t2.scheduleid  LEFT JOIN movie t3 ON t2.movieid = t3.movieid WHERE t1.userid = #{userid} order by showdate desc, showtime desc")
    List<OrderScheduleMovieOV> getUserOrdersList(Integer userid);
}
