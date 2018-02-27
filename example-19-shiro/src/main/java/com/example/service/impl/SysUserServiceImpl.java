package com.example.service.impl;

import com.example.dao.SysUserDao;
import com.example.model.SysUser;
import com.example.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author runlin.chen
 * @version 1.0 2018-02-27 11:16
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public SysUser findByUsername(String username) {
        System.out.println("SysUserServiceImpl.findByUsername()");
        return sysUserDao.findByUsername(username);
    }
}
