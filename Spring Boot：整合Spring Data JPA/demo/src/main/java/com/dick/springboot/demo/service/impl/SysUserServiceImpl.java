package com.dick.springboot.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dick.springboot.demo.dao.SysUserDao;
import com.dick.springboot.demo.model.SysUser;
import com.dick.springboot.demo.service.SysUserService;
import com.dick.springboot.demo.util.PageQuery;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public void save(SysUser user) {
        sysUserDao.save(user);
    }

    @Override
    public void delete(SysUser user) {
        sysUserDao.delete(user);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    @Override
    public Object findPage(PageQuery pageQuery) {
        return sysUserDao.findAll(PageRequest.of(pageQuery.getPage(), pageQuery.getSize()));
    }

}