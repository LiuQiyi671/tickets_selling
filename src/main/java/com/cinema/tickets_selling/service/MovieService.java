package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.Movie;

import java.util.List;

public interface MovieService extends IService<Movie> {

    //管理员发布影片
    Movie addMovie(Movie movie);

    //管理员根据影片id删除已发布影片
    void removeMovie(Long id);

    //管理员更新已发布影片信息
    Movie updateMovie(Movie movie);

    //查询所有正在热映影片列表
    List<Movie> getHotMovieList(String movieclassify);

    //查询所有即将上映影片列表
    List<Movie> getUpcomingMovieList(String movieclassify);

    //根据影片id获取已发布影片信息
    Movie showMovieInfo(Long id);

    //管理员根据影片名称查询影片相关信息
    Movie selectOneMovie(String moviename);
}
