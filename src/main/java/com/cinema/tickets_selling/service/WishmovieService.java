package com.cinema.tickets_selling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.tickets_selling.entity.Wishmovie;

public interface WishmovieService extends IService<Wishmovie> {

    //用户添加想看影片
    Wishmovie addWishMovie(Long userid, Long movieid);

    //用户取消想看影片
    void removeWishMovie(Long userid, Long movieid);

    //用户根据用户id查询其所有想看影片id列表
    Long[] getWishMovieByUserId(Long userid);
}
