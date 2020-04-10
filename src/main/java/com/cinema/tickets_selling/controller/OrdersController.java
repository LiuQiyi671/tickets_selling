package com.cinema.tickets_selling.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cinema.tickets_selling.entity.Orders;
import com.cinema.tickets_selling.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Api
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {

        this.ordersService = ordersService;
    }

    @ApiOperation("用户购票下单")
    @PostMapping("/user/addorder")
    public Orders userAddOrder(@RequestBody Orders order)
    {
        return ordersService.userAddOrder(order);
    }


    @ApiOperation("用户退票")
    @PostMapping("/user/withdraw")
    public Boolean userRemoveOrder(@RequestParam("id") Long id){
        ordersService.userRemoveOrder(id);
        return true;
    }


    @ApiOperation("用户根据订单id获取订单信息")
    @GetMapping("/user/order_info")
    public Orders showOrderInfo(@RequestParam("id") Long id){
        return ordersService.showOrderInfo(id);
    }


    @ApiOperation("管理员根据排片id查询某一场次所有订单列表")
    @GetMapping("/admin/order_list/{page}")
    public IPage<Orders> getOrdersListByScheduleId(@PathVariable("page") int page){

        Page<Orders> p = new Page<Orders>(page,10);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("orderid", 0);

        return ordersService.getOrdersListByScheduleId(p,queryWrapper);
    }
}
