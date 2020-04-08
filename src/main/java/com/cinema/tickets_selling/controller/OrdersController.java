package com.cinema.tickets_selling.controller;

import com.cinema.tickets_selling.service.OrdersService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Api
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {

        this.ordersService = ordersService;
    }
}
