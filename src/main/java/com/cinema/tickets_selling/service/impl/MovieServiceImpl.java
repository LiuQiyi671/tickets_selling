package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.tickets_selling.dao.MovieMapper;
import com.cinema.tickets_selling.entity.Movie;
import com.cinema.tickets_selling.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

    @Autowired
    private final MovieMapper movieMapper;

    public MovieServiceImpl(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }


    @Override
    public Movie addMovie(Movie movie) {
        int rows = movieMapper.insert(movie);
        if (rows == 1) {
            return movie;
        } else {
            return null;
        }
    }

    @Override
    public void removeMovie(Integer id) {
        movieMapper.deleteById(id);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        int rows = movieMapper.updateById(movie);
        if (rows == 1) {
            return movie;
        } else {
            return null;
        }    }

    @Override
    public List<Movie> getHotMovieList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("movieclassify","热映影片");
        List<Movie> hotmovielist = movieMapper.selectList(queryWrapper);
        return hotmovielist;
    }

    @Override
    public List<Movie> getUpcomingMovieList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("movieclassify","即将上映");
        List<Movie> upcomingmovielist = movieMapper.selectList(queryWrapper);
        return upcomingmovielist;
    }

    @Override
    public Movie showMovieInfo(Integer id) {
        return movieMapper.selectById(id);
    }

    @Override
    public Movie selectOneMovie(String moviename) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("moviename",moviename);
        return movieMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Movie> getAdminHotmovieList(Page p, QueryWrapper queryWrapper) throws RuntimeException{
        try {
            IPage<Movie> iPage = movieMapper.selectPage(p,queryWrapper);
            return iPage;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public IPage<Movie> getAdminUpcomingmovieList(Page p, QueryWrapper queryWrapper) throws RuntimeException{
        try {
            IPage<Movie> iPage = movieMapper.selectPage(p,queryWrapper);
            return iPage;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
