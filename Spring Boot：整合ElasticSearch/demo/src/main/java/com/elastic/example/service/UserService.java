package com.elastic.example.service;

import com.elastic.example.entity.po.User;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/9/17
 */
public interface UserService {


    /**获取用户信息
     * @param Id
     * @return
     */
    public User getUser(String Id);
}
