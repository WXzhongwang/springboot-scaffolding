package com.elastic.example.service.impl;

import com.elastic.example.dao.UserDao;
import com.elastic.example.entity.Commodity;
import com.elastic.example.entity.CommodityRepository;
import com.elastic.example.entity.po.User;
import com.elastic.example.service.CommodityService;
import com.elastic.example.service.UserService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2019/8/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String id){
        return userDao.getUser(id);
    }
}