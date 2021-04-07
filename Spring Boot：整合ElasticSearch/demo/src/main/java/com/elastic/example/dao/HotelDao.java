package com.elastic.example.dao;

import com.elastic.example.entity.po.Hotel;
import com.elastic.example.entity.po.MeiShi;

import java.util.List;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/9/17
 */
public interface HotelDao {

    /** 获取酒店列表
     * @return
     */
    public List<Hotel> getHotelList();

    /** 获取推荐酒店列表
     * @return
     */
    //public List<Hotel> getRecommendHotelList();

}
