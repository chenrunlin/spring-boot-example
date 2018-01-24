package com.example.DirectCite;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接引用配置文件属性
 * 通过注解@Value(value=”${config.name}”)就可以绑定到你想要的属性上面
 * @author runlin.chen
 * @version 1.0 2017-12-07 17:22
 **/
@RestController
public class User1Controller {

    @Value("${com.example.name}")
    private  String name;
    @Value("${com.example.want}")
    private  String want;

    @RequestMapping("/")
    public String hexo(){
        return "直接引用配置文件属性：" + name + "," + want;
    }
}
