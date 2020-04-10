package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.News;

import java.util.List;

public interface NewsService extends IService<News> {

    //管理员发布资讯
    News addNews(News news);

    //管理员根据资讯id删除已发布资讯
    void removeNews(Long id);

    //管理员更新已发布资讯信息
    News updateNews(News news);

    //用户根据资讯id查看资讯内容
    News showNewsInfo(Long id);

    //用户查询资讯列表前10条资讯
    List<News> getShortNewsList();

    //用户查询所有资讯列表
    List<News> getNewsList();

}
