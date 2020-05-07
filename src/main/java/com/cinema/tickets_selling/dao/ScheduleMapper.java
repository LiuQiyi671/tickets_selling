package com.cinema.tickets_selling.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cinema.tickets_selling.entity.Schedule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScheduleMapper extends BaseMapper<Schedule> {

    @Select("select * from schedule where movieid = #{movieid}")
    List<Schedule> showScheduleInfo(Integer movieid);

}
