package com.dick.springboot.demo.service;

import java.util.List;

import com.dick.springboot.demo.model.SysUser;

public interface SysUserService {

    /**
     * 查找所有用户
     * 
     * @return
     */
    List<SysUser> findAll();

}