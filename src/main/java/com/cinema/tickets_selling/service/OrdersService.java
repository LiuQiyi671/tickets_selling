package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.Orders;

public interface OrdersService extends IService<Orders> {

    //用户购票下单
    Orders userAddOrder(Orders order);

    //用户取消订单
    void userRemoveOrder(Long orderid);

    //用户根据订单id查看订单信息
    Orders showOrderInfo(Long orderid);

    //管理员根据排片id查看影片在本场次所有订单列表
    IPage<Orders> getOrdersListByScheduleId(Page p, QueryWrapper queryWrapper);
}
