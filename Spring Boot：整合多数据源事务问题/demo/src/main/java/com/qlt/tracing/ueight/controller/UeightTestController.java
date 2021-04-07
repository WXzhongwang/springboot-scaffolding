package com.qlt.tracing.ueight.controller;

import com.qlt.tracing.ueight.mapper.UeightTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ueight")
public class UeightTestController {

    @Autowired
    UeightTestMapper testMapper;


    @RequestMapping(value = "getAll")
    public int getAll(){
        Integer integer = testMapper.countAll();
        return integer;
    }

}
