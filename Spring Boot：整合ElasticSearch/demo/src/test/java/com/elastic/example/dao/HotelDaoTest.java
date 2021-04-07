package com.elastic.example.dao;

import com.elastic.example.entity.po.Hotel;
import com.elastic.example.entity.po.MeiShi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/9/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelDaoTest {

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private MeiShiDao meishiDao;

    @Test
    public  void test() {
        List<Hotel> hotelList = hotelDao.getHotelList();
        for (Hotel hotel:
             hotelList) {
            System.out.println(hotel);
        }
    }
    @Test
    public  void meishi() {
        List<MeiShi> meishiList = meishiDao.getMeiShiList();
        for (MeiShi meishi:
                meishiList) {
            System.out.println(meishi);
        }
    }
}
