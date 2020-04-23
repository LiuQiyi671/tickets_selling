package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.tickets_selling.dao.ScheduleMapper;
import com.cinema.tickets_selling.entity.Schedule;
import com.cinema.tickets_selling.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements ScheduleService {

    @Autowired
    private final ScheduleMapper scheduleMapper;

    public ScheduleServiceImpl(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public Schedule adminAddSchedule(Schedule schedule) {
        int rows = scheduleMapper.insert(schedule);
        if (rows == 1) {
            return schedule;
        } else {
            return null;
        }
    }

    @Override
    public void adminRemoveSchedule(Long scheduleid) {
        scheduleMapper.deleteById(scheduleid);
    }

    @Override
    public Schedule showScheduleInfo(Long scheduleid) {
        return scheduleMapper.selectById(scheduleid);
    }

//    @Override
//    public IPage<Schedule> getScheduleList(Page p, QueryWrapper queryWrapper) throws RuntimeException {
//        try {
//            IPage<Schedule> iPage = scheduleMapper.selectPage(p,queryWrapper);
//            return iPage;
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }


    @Override
    public IPage<Schedule> getScheduleListByMovieId(Page p, QueryWrapper queryWrapper) throws RuntimeException {
        try {
            IPage<Schedule> iPage = scheduleMapper.selectPage(p,queryWrapper);
            return iPage;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
