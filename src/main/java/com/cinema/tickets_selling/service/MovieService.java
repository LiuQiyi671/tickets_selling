package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.Movie;

import java.util.List;

public interface MovieService extends IService<Movie> {

    Movie addMovie(Movie movie);

    void removeMovie(Long id);

    Movie updateMovie(Movie movie);

    List<Movie> getHotMovieList(String movieclassify);

    List<Movie> getUpcomingMovieList(String movieclassify);

    Movie showMovieInfo(Long id);

    Movie selectOneMovie(String moviename);
}
