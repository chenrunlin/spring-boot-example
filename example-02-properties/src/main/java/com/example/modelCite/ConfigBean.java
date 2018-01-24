package com.example.modelCite;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性文件对应的类
 * 1、有时候属性太多了，一个个绑定到属性字段上太累，官方提倡绑定一个对象的bean，这里我们建一个ConfigBean.java类，
 * 顶部需要使用注解@ConfigurationProperties(prefix = “com.example”)来指明使用哪个
 * 2、在spring Boot入口类加上@EnableConfigurationProperties并指明要加载哪个bean，
 * 如果不写ConfigBean.class，在bean类那边添加
 * @author runlin.chen
 * @version 1.0 2017-12-07 17:28
 **/

@ConfigurationProperties(prefix = "com.example")
public class ConfigBean {

    private String name;
    private String want;
    private String hope;    //用于参数间引用

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getHope() {
        return hope;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }
}
