package com.cinema.tickets_selling.controller;

import com.cinema.tickets_selling.entity.News;
import com.cinema.tickets_selling.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Api
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {

        this.newsService = newsService;
    }
    @ApiOperation("管理员发布资讯")
    @PostMapping("/admin/news/add_news")
    public News addNews(@RequestBody News news)
    {
        return newsService.addNews(news);
    }

    @ApiOperation("管理员删除资讯")
    @PostMapping("/admin/news/delete_news")
    public Boolean deleteNews(@RequestParam("id") Long id){
        newsService.removeNews(id);
        return true;
    }

    @ApiOperation("管理员修改资讯信息")
    @PostMapping("/admin/news/update_news/{id}")
    public Boolean updateNews(@PathVariable("id") News news){
        newsService.updateNews(news);
        return true;
    }

    @ApiOperation("用户获取资讯内容")
    @GetMapping("/user/news/news_info")
    public News showNewsInfo(@RequestParam("id") Long id){
        return newsService.showNewsInfo(id);
    }

    @ApiOperation("用户查询前十条资讯")
    @GetMapping("/user/news/short_news_list")
    public List<News> getShortNewsList(){
        return newsService.getShortNewsList();
    }

    @ApiOperation("用户查询所有资讯列表")
    @GetMapping("/user/news/news_list")
    public List<News> userGetNewsList(){
        return newsService.getNewsList();
    }

    @ApiOperation("管理员查询所有资讯列表")
    @GetMapping("/admin/news/news_list")
    public List<News> adminGetNewsList(){
        return newsService.getNewsList();
    }
}
