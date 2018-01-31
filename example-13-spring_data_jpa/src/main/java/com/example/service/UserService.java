package com.example.service;

import com.example.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author runlin.chen
 * @version 1.0 2018-01-25 18:30
 **/
public interface UserService {

    /**
     * 复杂/多条件组合分页查询
     * @param user
     * @param pageable
     * @return
     */
    Page<User> getUserListByPage(User user, Pageable pageable);

}
