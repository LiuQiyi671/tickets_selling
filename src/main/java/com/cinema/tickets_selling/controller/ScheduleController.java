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

import java.math.BigDecimal;
import java.util.List;

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


    @ApiOperation("根据影片id获取排片信息")
    @GetMapping("/schedule/schedule_list")
    public List<Schedule> showScheduleInfo(@RequestParam("id") Integer id){
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

    @ApiOperation("根据排片id查询本场次所有信息")
    @GetMapping("/schedule/schedule_info")
    public Schedule getScheduleListByMovieId(@RequestParam("scheduleid") Integer scheduleid){
        return scheduleService.getScheduleInfo(scheduleid);
    }

    @ApiOperation("根据排片id更新场次座位信息")
    @PostMapping("/schedule/update_schedule")
    public Boolean updateScheduleSeatInfo(@RequestParam("scheduleid") Integer scheduleid,
                                          @RequestParam("movieid") Integer movieid,
                                          @RequestParam("hallname") String hallname,
                                          @RequestParam("showdate") String showdate,
                                          @RequestParam("showtime") String showtime,
                                          @RequestParam("price") BigDecimal price,
                                          @RequestParam("seat") String seat){
        Schedule schedule = new Schedule();
        schedule.setScheduleid(scheduleid);
        schedule.setMovieid(movieid);
        schedule.setHallname(hallname);
        schedule.setShowdate(showdate);
        schedule.setShowtime(showtime);
        schedule.setPrice(price);
        schedule.setSeat(seat);
        scheduleService.updateScheduleSeatInfo(schedule);
        return true;
    }
}
