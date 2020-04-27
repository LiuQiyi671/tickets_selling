package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.Schedule;

public interface ScheduleService extends IService<Schedule> {

    //管理员添加排片
    Schedule adminAddSchedule(Schedule schedule);

    //管理员根据排片id删除已发布排片
    void adminRemoveSchedule(Integer scheduleid);

    //管理员根据排片id查看本场次相关信息
    Schedule showScheduleInfo(Integer scheduleid);

//    IPage<Schedule> getScheduleList(Page p, QueryWrapper queryWrapper);

    IPage<Schedule> getScheduleListByMovieId(Page p, QueryWrapper queryWrapper);

}
