package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2021/4/29
 */
@RestController
@RequestMapping("/test")
public class HomeController {

    @GetMapping("/hello")
    public String index() {
        String strRtn = null;
        Entry entry = null;
        try {
            entry = SphU.entry("HelloWorld");
            /*您的业务逻辑 - 开始*/
            strRtn = "hello word!";
            /*您的业务逻辑 - 结束*/
        } catch (BlockException e1) {
            /*流控逻辑处理 - 开始*/
            System.out.println("block!");
            /*流控逻辑处理 - 结束*/
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return strRtn;
    }

}
