package com.cinema.tickets_selling.controller;

import com.cinema.tickets_selling.service.WishmovieService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Api
public class WishmovieController {

    private final WishmovieService wishmovieService;

    public WishmovieController(WishmovieService wishmovieService) {

        this.wishmovieService = wishmovieService;
    }
}
