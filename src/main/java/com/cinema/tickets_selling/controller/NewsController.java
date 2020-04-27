package com.cinema.tickets_selling.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public Boolean deleteNews(@RequestParam("id") Integer id){
        newsService.removeNews(id);
        return true;
    }

    @ApiOperation("管理员修改资讯信息")
    @PostMapping("/admin/news/update_news")
    public Boolean updateNews(@RequestParam("newsid") Integer newsid,
                              @RequestParam("newstitle") String newstitle,
                              @RequestParam("newsaddtime") String newsaddtime,
                              @RequestParam("news") String news){
        News newss = new News();
        newss.setNewsid(newsid);
        newss.setNewstitle(newstitle);
        newss.setNewsaddtime(newsaddtime);
        newss.setNews(news);
        newsService.updateNews(newss);
        return true;
    }

    @ApiOperation("用户获取资讯内容")
    @GetMapping("/user/news/news_info")
    public News showNewsInfo(@RequestParam("id") Integer id){
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
        return newsService.getUserNewsList();
    }

    @ApiOperation("管理员查询所有资讯列表")
    @GetMapping("/admin/news_list/{page}")
    public IPage<News> adminGetNewsList(@PathVariable("page") int page){
        Page<News> p = new Page<News>(page,5);
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("newsid", 0).orderByDesc("newsaddtime");

        return newsService.getAdminNewsList(p,queryWrapper);
    }
}
