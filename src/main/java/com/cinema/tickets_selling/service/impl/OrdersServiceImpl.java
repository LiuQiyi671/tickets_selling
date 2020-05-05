package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.tickets_selling.dao.OrdersMapper;
import com.cinema.tickets_selling.entity.Orders;
import com.cinema.tickets_selling.entity.VO.OrderScheduleMovieOV;
import com.cinema.tickets_selling.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private final OrdersMapper ordersMapper;

    public OrdersServiceImpl(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    @Override
    public Orders userAddOrder(Orders order) {
        int rows = ordersMapper.insert(order);
        if (rows == 1) {
            return order;
        } else {
            return null;
        }
    }

    @Override
    public void userRemoveOrder(Integer orderid) {
        ordersMapper.deleteById(orderid);
    }

    @Override
    public Orders showOrderInfo(Integer orderid) {
        return ordersMapper.selectById(orderid);
    }

    @Override
    public List<OrderScheduleMovieOV> getUserOrdersList(Integer userid) {
//        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
//        queryWrapper.ge("orderid","0").eq("userid",userid);
//        return ordersMapper.selectList(queryWrapper);
        return ordersMapper.getUserOrdersList(userid);
    }

    @Override
    public IPage<Orders> getOrdersListByScheduleId(Page p, QueryWrapper queryWrapper) throws RuntimeException {
        try {
            IPage<Orders> iPage = ordersMapper.selectPage(p,queryWrapper);
            return iPage;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
