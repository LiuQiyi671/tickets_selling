package com.cinema.tickets_selling.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cinema.tickets_selling.entity.Orders;
import com.cinema.tickets_selling.entity.Schedule;
import com.cinema.tickets_selling.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Api
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {

        this.scheduleService = scheduleService;
    }

    @ApiOperation("管理员添加排片")
    @PostMapping("/admin/addschedule")
    public Schedule adminAddSchedule(@RequestBody Schedule schedule)
    {
        return scheduleService.adminAddSchedule(schedule);
    }


    @ApiOperation("管理员根据排片id删除排片")
    @PostMapping("/admin/delete_schedule")
    public Boolean adminRemoveSchedule(@RequestParam("id") Integer id){
        scheduleService.adminRemoveSchedule(id);
        return true;
    }


    @ApiOperation("管理员根据排片id获取排片信息")
    @GetMapping("/admin/schedule_info")
    public Schedule showScheduleInfo(@RequestParam("id") Integer id){
        return scheduleService.showScheduleInfo(id);
    }


//    @ApiOperation("管理员查询所有排片列表")
//    @GetMapping("/admin/schedule_list/{page}")
//    public IPage<Schedule> getScheduleList(@PathVariable("page") int page){
//
//        Page<Schedule> p = new Page<Schedule>(page,10);
//        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
//        queryWrapper.gt("scheduleid", 0);
//
//        return scheduleService.getScheduleList(p,queryWrapper);
//    }


    @ApiOperation("管理员根据影片id查询此影片所有场次")
    @GetMapping("/admin/schedule_list/{page}")
    public IPage<Schedule> getScheduleListByMovieId(@PathVariable("page") int page,
                                                   @RequestParam("movieid") Integer movieid){

        Page<Schedule> p = new Page<Schedule>(page,10);
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("scheduleid", 0).eq("movieid",movieid);

        return scheduleService.getScheduleListByMovieId(p,queryWrapper);
    }
}
