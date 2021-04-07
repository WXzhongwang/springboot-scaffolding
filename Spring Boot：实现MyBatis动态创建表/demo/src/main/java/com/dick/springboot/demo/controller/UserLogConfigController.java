package com.dick.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dick.springboot.demo.model.UserLogConfig;
import com.dick.springboot.demo.service.UserLogConfigService;

@RestController
@RequestMapping("user/log/config")
public class UserLogConfigController {

    @Autowired
    private UserLogConfigService userLogConfigService;

    @PostMapping(value = "/save")
    public Object save(@RequestBody UserLogConfig userLogConfig) {
        userLogConfigService.save(userLogConfig);
        return 1;
    }

    @GetMapping(value = "/findAll")
    public Object findAll() {
        return userLogConfigService.findAll();
    }
}