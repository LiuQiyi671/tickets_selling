package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.Movie;

import java.util.List;

public interface MovieService extends IService<Movie> {

    //管理员发布影片
    Movie addMovie(Movie movie);

    //管理员根据影片id删除已发布影片
    void removeMovie(Integer id);

    //管理员更新已发布影片信息
    Movie updateMovie(Movie movie);

    //查询所有正在热映影片列表
    List<Movie> getHotMovieList();

    //查询所有即将上映影片列表
    List<Movie> getUpcomingMovieList();

    //根据影片id获取已发布影片信息
    Movie showMovieInfo(Integer id);

    //管理员根据影片名称查询影片相关信息
    Movie selectOneMovie(String moviename);

    //管理员查询所有热映影片列表
    IPage<Movie> getAdminHotmovieList(Page p, QueryWrapper queryWrapper);

    //管理员查询所有即将上映影片列表
    IPage<Movie> getAdminUpcomingmovieList(Page p, QueryWrapper queryWrapper);
}
