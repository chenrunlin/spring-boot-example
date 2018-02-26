package com.example.model;

import java.io.Serializable;

/**
 * @author runlin.chen
 * @version 1.0 2018-02-24 16:21
 **/
public class User implements Serializable{

    private static final long serialVersionUID = -5118918047914085111L;

    private String username;

    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
