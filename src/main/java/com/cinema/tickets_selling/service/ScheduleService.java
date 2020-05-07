package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.Schedule;

import java.util.List;

public interface ScheduleService extends IService<Schedule> {

    //管理员添加排片
    Schedule adminAddSchedule(Schedule schedule);

    //管理员根据排片id删除已发布排片
    void adminRemoveSchedule(Integer scheduleid);

    //根据影片id查看本影片所有场次相关信息
    List<Schedule> showScheduleInfo(Integer movieid);

//    IPage<Schedule> getScheduleList(Page p, QueryWrapper queryWrapper);

    IPage<Schedule> getScheduleListByMovieId(Page p, QueryWrapper queryWrapper);

    //更新影片座位信息
    Schedule updateScheduleSeatInfo(Schedule schedule);

//    根据排片id获取本场次所有信息
    Schedule getScheduleInfo(Integer scheduleid);

}
