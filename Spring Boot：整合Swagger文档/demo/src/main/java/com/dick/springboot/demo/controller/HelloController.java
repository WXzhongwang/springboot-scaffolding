package com.dick.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author shengwangzhong
 */
@Api(value = "desc of class")
@RestController
public class HelloController {

    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value = "/hello")
    public Object hello( /* 参数注解 */ @ApiParam(value = "desc of param", required = true) @RequestParam String name) {
        return "Hello " + name + "!";
    }
}