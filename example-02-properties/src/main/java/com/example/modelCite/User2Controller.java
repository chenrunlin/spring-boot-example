package com.example.modelCite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过对象引用的方式，直接把配置文件中的属性赋值给对象
 * @author runlin.chen
 * @version 1.0 2017-12-07 17:36
 **/
@RestController
public class User2Controller {

    @Autowired
    ConfigBean configBean;

    @RequestMapping("/model_cite")
    public String model_cite(){
        String str1 = "通过对象引用的方式：" + configBean.getName() + configBean.getWant();
        String str2 = "通过参数间引用的方式：" + configBean.getHope(); //参数间引用
        return str1 + "<br/>" + str2;
    }
}
