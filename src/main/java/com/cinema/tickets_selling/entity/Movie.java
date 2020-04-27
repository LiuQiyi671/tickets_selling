package com.cinema.tickets_selling.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("movie")
public class Movie implements Serializable {

    //主键：影片id
    @TableId
    private Integer movieid;

    //影片名称
    private String moviename;

    //影片类型：热映影片 or 即将上映
    private String movieclassify;

    //影片导演
    private String moviedirector;

    //影片题材
    private String movietype;

    //影片发行地区
    private String moviecountry;

    //影片时长
    private String movieduration;

    //影片主演
    private String movieactor;

    //影片语言
    private String movielanguage;

    //影片封面图
    private byte[] file;

    //影片上映时间
    private String moviepublicdate;

    //影片简介
    private String moviedescription;

    //影片想看人数
    private Integer moviewishpeoplenum;

}
