package com.qlt.tracing.self.controller;

import com.qlt.tracing.self.mapper.TestMapper;
import com.qlt.tracing.self.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class TestController {

    @Autowired
    TestMapper testMapper;

    @Autowired
    TestService testService;


    @RequestMapping(value = "getAll")
    public int getAll(){
        Integer integer = testMapper.countAll();
        return integer;
    }


    @RequestMapping(value = "updateAge")
    public int updateAge(){
        testService.updatAge();
        return 1;
    }
}
