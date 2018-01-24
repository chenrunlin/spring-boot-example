package com.example.randomConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author runlin.chen
 * @version 1.0 2017-12-08 9:49
 **/

@RestController
public class RandomController {

    @Autowired
    private RandomBean randomBean;

    @RequestMapping("/random")
    public String random(){
        return "随机值属性：<br/>" +
                "uuid：" + randomBean.getUuid() + "<br/>" +
                "secret：" + randomBean.getSecret() + "<br/>" +
                "number：" + randomBean.getNumber() + "<br/>" +
                "bignNmber：" + randomBean.getBignNmber() + "<br/>" +
                "smallNmber：" + randomBean.getSmallNmber() + "<br/>" +
                "range：" + randomBean.getRange() + "<br/>";
    }

    @RequestMapping("/random1")
    public String random1(){
        return "随机值属性：<br/>" +
                "uuid：" + randomBean.getUuid() + "<br/>" +
                "secret：" + randomBean.getSecret() + "<br/>" +
                "number：" + randomBean.getNumber() + "<br/>" +
                "bignNmber：" + randomBean.getBignNmber() + "<br/>" +
                "smallNmber：" + randomBean.getSmallNmber() + "<br/>" +
                "range：" + randomBean.getRange() + "<br/>";
    }

    @RequestMapping("/random2")
    public String random2(){
        return "随机值属性：<br/>" +
                "uuid：" + randomBean.getUuid() + "<br/>" +
                "secret：" + randomBean.getSecret() + "<br/>" +
                "number：" + randomBean.getNumber() + "<br/>" +
                "bignNmber：" + randomBean.getBignNmber() + "<br/>" +
                "smallNmber：" + randomBean.getSmallNmber() + "<br/>" +
                "range：" + randomBean.getRange() + "<br/>";
    }

}
