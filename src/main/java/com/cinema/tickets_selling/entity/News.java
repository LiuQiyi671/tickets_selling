package com.cinema.tickets_selling.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("news")
public class News implements Serializable {

    //主键：资讯id
    @TableId
    private Long newsid;

    //资讯标题
    private String newstitle;

    //资讯发布时间
    private Timestamp newsaddtime;

    //资讯内容
    private String news;

}
