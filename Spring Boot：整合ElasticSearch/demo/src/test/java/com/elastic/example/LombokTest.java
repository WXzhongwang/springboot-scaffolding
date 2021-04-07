package com.elastic.example;

import com.elastic.example.entity.po.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/9/17
 */
@RunWith(JUnit4.class)
public class LombokTest {
    @Test
    public void test(){
        Hotel hotel = Hotel.builder()
                .type("舒适型")
                .address("西湖区留下街道留和路石马新村65号（近科技学院、宝寿山景区）")
                .name("小时光客栈(石马店)")
                .build();
        System.out.println(hotel);
    }
}
