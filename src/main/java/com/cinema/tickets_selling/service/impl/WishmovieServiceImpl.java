package com.cinema.tickets_selling.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.tickets_selling.dao.WishmovieMapper;
import com.cinema.tickets_selling.entity.Wishmovie;
import com.cinema.tickets_selling.service.WishmovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishmovieServiceImpl extends ServiceImpl<WishmovieMapper, Wishmovie> implements WishmovieService {

    @Autowired
    private final WishmovieMapper wishmovieMapper;

    public WishmovieServiceImpl(WishmovieMapper wishmovieMapper) {
        this.wishmovieMapper = wishmovieMapper;
    }


    @Override
    public Wishmovie addWishMovie(Long userid, Long movieid) {
        Wishmovie wishmovie = new Wishmovie();
        wishmovie.setWishmovieid(null);
        wishmovie.setUserid(userid);
        wishmovie.setMovieid(movieid);
        int rows = wishmovieMapper.insert(wishmovie);
        if (rows == 1) {
            return wishmovie;
        } else {
            return null;
        }
    }

    @Override
    public void removeWishMovie(Long userid, Long movieid) {
        QueryWrapper<Wishmovie> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid).eq("movieid",movieid);
        wishmovieMapper.delete(queryWrapper);
    }

    @Override
    public Long[] getWishMovieByUserId(Long userid) {
        QueryWrapper<Wishmovie> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid);

        int count = 0;
        Long intArr[] = new Long[wishmovieMapper.selectList(queryWrapper).size()];
        for( int i = 0; i < wishmovieMapper.selectList(queryWrapper).size(); i++ ) {
            intArr[count] = wishmovieMapper.selectList(queryWrapper).get(i).getMovieid();
            count++;
        }

        return intArr;
    }
}
