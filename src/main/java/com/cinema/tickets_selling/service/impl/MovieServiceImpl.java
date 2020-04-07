package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public void removeMovie(Long id) {
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
    public List<Movie> getHotMovieList(String movieclassify) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("movieclassify","热映影片");
        List<Movie> hotmovielist = movieMapper.selectList(queryWrapper);
        return hotmovielist;
    }

    @Override
    public List<Movie> getUpcomingMovieList(String movieclassify) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("movieclassify","即将上映");
        List<Movie> upcomingmovielist = movieMapper.selectList(queryWrapper);
        return upcomingmovielist;
    }

    @Override
    public Movie showMovieInfo(Long id) {
        return movieMapper.selectById(id);
    }

    @Override
    public Movie selectOneMovie(String moviename) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("moviename",moviename);
        return movieMapper.selectOne(queryWrapper);
    }
}
