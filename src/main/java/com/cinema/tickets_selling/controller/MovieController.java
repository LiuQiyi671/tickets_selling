package com.cinema.tickets_selling.controller;

import com.cinema.tickets_selling.entity.Movie;
import com.cinema.tickets_selling.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Api
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService1) {

        this.movieService = movieService1;
    }

    @ApiOperation("管理员添加电影")
    @PostMapping("/admin/movie/add_movie")
    public Movie addMovie(@RequestParam("file")MultipartFile file,
                          @RequestParam("moviename") String moviename,
                          @RequestParam("movieclassify") String movieclassify,
                          @RequestParam("moviedirector") String moviedirector,
                          @RequestParam("movietype") String movietype,
                          @RequestParam("moviecountry") String moviecountry,
                          @RequestParam("movieduration") String movieduration,
                          @RequestParam("movieactor") String movieactor,
                          @RequestParam("movielanguage") String movielanguage,
                          @RequestParam("moviedescription") String moviedescription,
                          @RequestParam("moviepublicdate") String moviepublicdate,
                          @RequestParam("moviewishpeoplenum") Integer moviewishpeoplenum) throws ParseException, IOException {
        Movie movie = new Movie();
        movie.setMovietype(movietype);
        movie.setMoviename(moviename);
        movie.setMovieid(null);
        movie.setMoviepublicdate(moviepublicdate);
        movie.setMovielanguage(movielanguage);
        movie.setMovieduration(movieduration);
        movie.setMoviedirector(moviedirector);
        movie.setMoviedescription(moviedescription);
        movie.setMoviecountry(moviecountry);
        movie.setMovieclassify(movieclassify);
        movie.setMovieactor(movieactor);
        movie.setMoviewishpeoplenum(moviewishpeoplenum);
        movie.setFile(file.getBytes());
        return movieService.addMovie(movie);
    }

    @ApiOperation("管理员删除电影")
    @PostMapping("/admin/movie/delete_movie")
    public Boolean deleteMovie(@RequestParam("id") Integer id){
        movieService.removeMovie(id);
        return true;
    }

    @ApiOperation("管理员修改电影信息")
    @PostMapping("/admin/movie/update_movie/{id}")
    public Boolean updateMovie(@PathVariable("id") Movie movie){
        movieService.updateMovie(movie);
        return true;
    }

    @ApiOperation("用户根据影片id获取电影信息")
    @GetMapping("/user/movie/movie_info")
    public Movie userGetMovieInfo(@RequestParam("id") Integer id){
        return movieService.showMovieInfo(id);
    }

    @ApiOperation("用户查询所有热映电影")
    @GetMapping("/user/movie/hot_movie_list")
    public List<Movie> userGetHotMovieList(){
        return movieService.getHotMovieList();
    }

    
    @ApiOperation("用户查询所有即将上映电影")
    @GetMapping("/user/movie/upcoming_movie_list")
    public List<Movie> userGetUpcomingMovieList(){
        return movieService.getUpcomingMovieList();
    }

    @ApiOperation("管理员获取电影信息")
    @GetMapping("/admin/movie/movie_info")
    public Movie adminGetMovieInfo(@RequestParam("id") Integer id){
        return movieService.showMovieInfo(id);
    }

    @ApiOperation("管理员查询所有热映电影")
    @GetMapping("/admin/movie/hot_movie_list")
    public List<Movie> getHotMovieList(){
        return movieService.getHotMovieList();
    }


    @ApiOperation("管理员查询所有即将上映电影")
    @GetMapping("/admin/movie/upcoming_movie_list")
    public List<Movie> getUpcomingMovieList(){
        return movieService.getUpcomingMovieList();
    }

    @ApiOperation("管理员根据电影名称查询电影信息")
    @GetMapping("/admin/movie/get_one_movie")
    public Movie getOneMovie(@RequestParam("moviename") String moviename){
        return movieService.selectOneMovie(moviename);
    }

}
