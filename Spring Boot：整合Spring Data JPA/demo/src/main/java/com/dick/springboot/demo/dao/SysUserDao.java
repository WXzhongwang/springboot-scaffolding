package com.dick.springboot.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dick.springboot.demo.model.SysUser;

public interface SysUserDao extends JpaRepository<SysUser, Long>, Serializable {

}