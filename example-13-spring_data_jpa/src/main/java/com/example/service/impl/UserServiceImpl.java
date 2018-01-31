package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.tools.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author runlin.chen
 * @version 1.0 2018-01-25 18:31
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    /**
     * Predicate : 中文意思是判断，断言的意思，放在我们的sql中就是where后面的东西
     * @param user
     * @param pageable
     * @return
     */
    @Override
    public Page<User> getUserListByPage(final User user, Pageable pageable) {
        return userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                if (null != user && !StringUtil.isNull(user.getName())) {
                    predicateList.add(cb.like(root.<String> get("name"), "%" + user.getName() + "%"));
                }
                if (null != user && !StringUtil.isNull(user.getAge() + "")) {
                    predicateList.add(cb.greaterThanOrEqualTo(root.<Integer> get("age"), + user.getAge()));
                }
                Predicate[] arrayPredicates = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(arrayPredicates));
            }
        }, pageable);
    }
}
