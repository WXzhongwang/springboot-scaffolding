package com.elastic.example.dao;

import com.elastic.example.entity.po.User;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/9/17
 */
public interface UserDao  {


    /** 获取用户信息
     * @param id
     * @return
     */
    public User getUser(String id);

    /** 更新用户基本信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);
}
