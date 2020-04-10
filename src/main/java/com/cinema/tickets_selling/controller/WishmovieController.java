package com.cinema.tickets_selling.controller;

import com.cinema.tickets_selling.entity.Wishmovie;
import com.cinema.tickets_selling.service.WishmovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Api
public class WishmovieController {

    private final WishmovieService wishmovieService;

    public WishmovieController(WishmovieService wishmovieService) {

        this.wishmovieService = wishmovieService;
    }

    @ApiOperation("用户添加想看影片")
    @PostMapping("/user/addwishmovie")
    public Wishmovie addWishMovie(@RequestParam("userid") Long userid,
                                  @RequestParam("movieid") Long movieid){
        return wishmovieService.addWishMovie(userid,movieid);
    }

    @ApiOperation("用户取消想看影片")
    @PostMapping("/user/removewishmovie")
    public void removeWishMovie(@RequestParam("userid") Long userid,
                                  @RequestParam("movieid") Long movieid){
        wishmovieService.removeWishMovie(userid,movieid);
    }

    @ApiOperation("根据用户id查看想看影片列表")
    @GetMapping("/user/getwishmovie")
    public Long[] getWishMovieByUserId(@RequestParam("userid") Long userid){
        return wishmovieService.getWishMovieByUserId(userid);
    }
}
