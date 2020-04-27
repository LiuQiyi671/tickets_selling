package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.tickets_selling.dao.NewsMapper;
import com.cinema.tickets_selling.entity.News;
import com.cinema.tickets_selling.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private final NewsMapper newsMapper;

    public NewsServiceImpl(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public News addNews(News news) {
        int rows = newsMapper.insert(news);
        if (rows == 1) {
            return news;
        } else {
            return null;
        }
    }

    @Override
    public void removeNews(Integer id) {
        newsMapper.deleteById(id);
    }

    @Override
    public News updateNews(News news) {
        int rows = newsMapper.updateById(news);
        if (rows == 1) {
            return news;
        } else {
            return null;
        }
    }

    @Override
    public News showNewsInfo(Integer id) {
        return newsMapper.selectById(id);
    }

    @Override
    public List<News> getShortNewsList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.between("newsid",0,10);
        List<News> NewsList = newsMapper.selectList(queryWrapper);
        return NewsList;
    }

    @Override
    public List<News> getUserNewsList() {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("newsid",0).orderByDesc("newsaddtime");
        List<News> NewsList = newsMapper.selectList(queryWrapper);
        return NewsList;
    }

    @Override
    public IPage<News> getAdminNewsList(Page p, QueryWrapper queryWrapper) throws RuntimeException {
        try {
            IPage<News> iPage = newsMapper.selectPage(p,queryWrapper);
            return iPage;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
