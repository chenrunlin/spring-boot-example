package com.example.repository;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author runlin.chen
 * @version 1.0 2018-01-24 16:32
 **/
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    /**
     * 命名参数
     * 利用JPQL进行查询操作
     * 描述：推荐使用这种方法，可以不用管参数的位置
     */
    @Query("from User u where u.name=:name")
    User findUserByName1(@Param("name") String name);

    /**
     * 索引参数
     * 利用原生的SQL进行查询操作
     * 描述：使用?占位符
     */
    @Query(value = "select * from user u where u.name=?1", nativeQuery = true)
    User findUserByName2(@Param("name") String name);

    /**
     * 利用JPQL进行修改操作
     * 描述：可以通过@Modifying和@Query来实现更新
     * 注意：1、jpa的硬性要求，'没有事务支持，不能执行更新和删除操作'。
     *  直接在方法上添加事务即可，在方法上加上@Transactional或在Service层上 加@Transactional
     * 2、Modifying queries的返回值只能为void或者是int/Integer
     *
     */
    @Modifying
    @Transactional
    @Query("update User u set u.name = :name where u.id = :id")
    int updateUserById(@Param("name") String name, @Param("id") Long id);

    /**
     * 利用原生的SQL进行修改操作
     * 描述：可以通过@Modifying和@Query来实现更新
     * 注意：1、jpa的硬性要求，'没有事务支持，不能执行更新和删除操作'。
     *  直接在方法上添加事务即可，在方法上加上@Transactional或在Service层上 加@Transactional
     * 2、Modifying queries的返回值只能为void或者是int/Integer
     *
     */
    @Modifying
    @Transactional
    @Query(value = "update user u set u.age = :age where u.id = :id", nativeQuery = true)
    int updateUserById(@Param("age") int age, @Param("id") Long id);

    /**
     * 利用JPQL进行修改操作
     * 描述：可以通过@Modifying和@Query来实现更新
     * 注意：1、jpa的硬性要求，'没有事务支持，不能执行更新和删除操作'。
     *  直接在方法上添加事务即可，在方法上加上@Transactional或在Service层上 加@Transactional
     * 2、Modifying queries的返回值只能为void或者是int/Integer
     *
     */

    @Modifying
    @Transactional
    @Query(value = "delete from User where name = :name")
    int deleteUserByName1(@Param("name") String name);
    /**
     * 利用原生的SQL进行删除操作
     * 描述：可以通过@Modifying和@Query来实现更新
     * 注意：1、jpa的硬性要求，'没有事务支持，不能执行更新和删除操作'。
     *  直接在方法上添加事务即可，在方法上加上@Transactional或在Service层上 加@Transactional
     * 2、Modifying queries的返回值只能为void或者是int/Integer
     *
     */
    @Modifying
    @Transactional
    @Query(value = "delete from user where name = :name", nativeQuery = true)
    int deleteUserByName2(@Param("name") String name);

    //默认分页
    Page<User> findByName(String name, Pageable pageable);

    /**
     * 利用JPQL进行分页操作
     */
    @Query("from User u where u.name = :name")
    Page<User> findByName1(@Param("name") String name, Pageable pageable);

}
