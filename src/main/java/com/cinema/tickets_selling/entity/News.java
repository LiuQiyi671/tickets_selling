package com.cinema.tickets_selling.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("news")
public class News implements Serializable {

    //主键：资讯id
    @TableId
    private Integer newsid;

    //资讯标题
    private String newstitle;

    //资讯发布时间
    private String newsaddtime;

    //资讯内容
    private String news;

}
