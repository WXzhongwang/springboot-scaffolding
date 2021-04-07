package com.elastic.example.dao;

import com.elastic.example.entity.po.MeiShi;

import java.util.List;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/9/17
 */
public interface MeiShiDao {

    /** 获取美食列表
     * @return
     */
    public List<MeiShi> getMeiShiList();

    /** 获取推荐美食列表
     * @return
     */
    //public List<MeiShi> getRecommendMeiShiList();

}
