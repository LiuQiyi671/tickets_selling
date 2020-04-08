package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.tickets_selling.dao.WishmovieMapper;
import com.cinema.tickets_selling.entity.Wishmovie;
import com.cinema.tickets_selling.service.WishmovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishmovieServiceImpl extends ServiceImpl<WishmovieMapper, Wishmovie> implements WishmovieService {

    @Autowired
    private final WishmovieMapper wishmovieMapper;

    public WishmovieServiceImpl(WishmovieMapper wishmovieMapper) {
        this.wishmovieMapper = wishmovieMapper;
    }
}
