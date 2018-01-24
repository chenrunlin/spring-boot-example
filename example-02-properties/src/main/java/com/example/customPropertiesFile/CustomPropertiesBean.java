package com.example.customPropertiesFile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 自定义属性文件对应类
 * 如果你使用的是1.5以前的版本，那么可以通过locations指定properties文件的位置，这样：
 * @ConfigurationProperties(prefix = "config2", locations="classpath:test.properties")
 * 但是1.5版本后就没有这个属性了
 *
 * @author runlin.chen
 * @version 1.0 2017-12-07 18:10
 **/
@Configuration
@ConfigurationProperties(prefix = "bsit.email")
@PropertySource("classpath:email.properties")
public class CustomPropertiesBean {

    private String host;

    private String from;

    private String username;

    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
