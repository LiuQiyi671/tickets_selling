package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.tickets_selling.dao.OrdersMapper;
import com.cinema.tickets_selling.entity.Orders;
import com.cinema.tickets_selling.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private final OrdersMapper ordersMapper;

    public OrdersServiceImpl(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

}
