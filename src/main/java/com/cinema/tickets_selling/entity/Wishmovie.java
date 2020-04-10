package com.cinema.tickets_selling.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("wishmovie")
public class Wishmovie implements Serializable {

    //主键：想看影片id
    @TableId
    private Long wishmovieid;

    //用户id
    private Long userid;

    //影片id
    private Long movieid;

//    @TableField(exist = false)
//    private User userentity;
//
//    @TableField(exist = false)
//    private Movie movieentity;
}
