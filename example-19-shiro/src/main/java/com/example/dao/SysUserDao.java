package com.example.dao;

import com.example.model.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author runlin.chen
 * @version 1.0 2018-02-27 11:14
 **/
public interface SysUserDao extends CrudRepository<SysUser, Long> {

    SysUser findByUsername(String username);

}
