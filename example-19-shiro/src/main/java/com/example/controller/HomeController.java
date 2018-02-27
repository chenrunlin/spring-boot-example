package com.example.controller;

import com.example.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author runlin.chen
 * @version 1.0 2018-02-27 11:19
 **/
@Controller
public class HomeController {

    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, SysUser user, Model model) throws Exception{
        System.out.println("HomeController.login()");
        String msg = "";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            msg = "登录成功";//重复成功登录会走到这
        } catch (Exception e) {
            // 登录失败从request中获取shiro处理的异常信息。
            // shiroLoginFailure:就是shiro异常类的全类名.
            String exception = (String) request.getAttribute("shiroLoginFailure");
            System.out.println("exception=" + exception);
            if (exception != null) {
                if (UnknownAccountException.class.getName().equals(exception)) {
                    System.out.println("UnknownAccountException -- > 账号不存在：");
                    msg = "UnknownAccountException -- > 账号不存在：";
                } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                    System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                    msg = "IncorrectCredentialsException -- > 密码不正确：";
                }  else if (LockedAccountException.class.getName().equals(exception)) {
                    System.out.println("LockedAccountException -- > 用户被冻结：");
                    msg = "LockedAccountException -- > 用户被冻结：";
                } else if ("kaptchaValidateFailed".equals(exception)) {
                    System.out.println("kaptchaValidateFailed -- > 验证码错误");
                    msg = "kaptchaValidateFailed -- > 验证码错误";
                } else {
                    msg = "else >> "+ exception;
                    System.out.println("else -- >" + exception);
                }
            }
        }
        model.addAttribute("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}
