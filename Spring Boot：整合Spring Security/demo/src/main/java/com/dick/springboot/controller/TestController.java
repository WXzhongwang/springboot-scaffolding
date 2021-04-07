package com.dick.springboot.controller;

import com.dick.springboot.threads.ThreadPoolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description 下单测试接口
 * @date created on 2019/11/25
 */
@RestController
public class TestController {

    @Autowired
    ThreadPoolManager manager;

    @GetMapping("/order")
    public String order(){
        //模拟的随机数
        String orderNo = System.currentTimeMillis() + UUID.randomUUID().toString();

        manager.addOrders(orderNo);

        return "Test Order Interface";
    }
}
