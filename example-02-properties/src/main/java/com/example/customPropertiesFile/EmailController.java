package com.example.customPropertiesFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过自定义属性文件方式获取属性
 * @author runlin.chen
 * @version 1.0 2017-12-07 18:14
 **/

@RestController
public class EmailController {

    @Autowired
    private CustomPropertiesBean customPropertiesBean;

    @RequestMapping("/custom_properties")
    public String custom_properties(){
        StringBuilder str1 = new StringBuilder();
        str1.append("通过自定义属性文件方式：<br/>");
        str1.append("host：").append(customPropertiesBean.getHost()).append("<br/>");
        str1.append("from：").append(customPropertiesBean.getFrom()).append("<br/>");
        str1.append("username：").append(customPropertiesBean.getUsername()).append("<br/>");
        str1.append("password：").append(customPropertiesBean.getPassword()).append("<br/>");
        return str1.toString();
    }
}
