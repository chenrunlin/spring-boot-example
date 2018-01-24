package com.example.randomConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author runlin.chen
 * @version 1.0 2017-12-08 9:59
 **/
@Configuration
@PropertySource("classpath:random.properties")
public class RandomBean {

    @Value("${bist.random.uuid}")
    private String uuid;

    @Value("${bist.random.secret}")
    private String secret;

    @Value("${bist.random.number}")
    private String number;

    @Value("${bist.random.bignumber}")
    private String bignNmber;

    @Value("${bist.random.number.less.than.ten}")
    private String smallNmber;

    @Value("${bist.random.number.in.range}")
    private String range;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBignNmber() {
        return bignNmber;
    }

    public void setBignNmber(String bignNmber) {
        this.bignNmber = bignNmber;
    }

    public String getSmallNmber() {
        return smallNmber;
    }

    public void setSmallNmber(String smallNmber) {
        this.smallNmber = smallNmber;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
