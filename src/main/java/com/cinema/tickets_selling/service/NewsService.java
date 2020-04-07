package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.News;

import java.util.List;

public interface NewsService extends IService<News> {

    News addNews(News news);

    void removeNews(Long id);

    News updateNews(News news);

    News showNewsInfo(Long id);

    List<News> getShortNewsList();

    List<News> getNewsList();

}
