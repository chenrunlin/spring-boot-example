package com.example.service;

import com.example.model.SysUser;

/**
 * @author runlin.chen
 * @version 1.0 2018-02-27 11:15
 **/
public interface SysUserService {

    SysUser findByUsername(String username);

}
