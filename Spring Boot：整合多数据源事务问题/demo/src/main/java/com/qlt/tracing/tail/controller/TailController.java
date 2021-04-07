package com.qlt.tracing.tail.controller;

import com.qlt.tracing.tail.mapper.TailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tail")
public class TailController {

    @Autowired
    TailMapper tailMapper;


    @RequestMapping(value = "getAll")
    public int getAll() {
        int all = tailMapper.getAll();
        return all;
    }


}
