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
    private Integer wishmovieid;

    //用户id
    private Integer userid;

    //影片id
    private Integer movieid;

//    @TableField(exist = false)
//    private User userentity;
//
//    @TableField(exist = false)
//    private Movie movieentity;
}
