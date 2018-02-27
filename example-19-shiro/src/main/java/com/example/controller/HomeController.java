package com.example.controller;

import com.example.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
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

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request) throws Exception{
        System.out.println("HomeController.toLogin()");
        return "/login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, SysUser user, Model model) throws Exception{
        System.out.println("HomeController.login()");
        String msg = "";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            return "redirect:/";
        } catch (UnknownAccountException e) {
            System.out.println("UnknownAccountException -- > 账号不存在：");
            msg = "UnknownAccountException -- > 账号不存在：";
        } catch (IncorrectCredentialsException e) {
            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
            msg = "IncorrectCredentialsException -- > 密码不正确：";
        } catch (ExcessiveAttemptsException e) {
            System.out.println("ExcessiveAttemptsException -- > 登录失败次数过多：");
            msg = "ExcessiveAttemptsException -- > 登录失败次数过多：";
        }  catch (LockedAccountException e) {
            System.out.println("LockedAccountException -- > 帐号被锁定：");
            msg = "LockedAccountException -- > 帐号被锁定：";
        } catch (DisabledAccountException e) {
            System.out.println("DisabledAccountException -- > 帐号被禁用：");
            msg = "DisabledAccountException -- > 帐号被禁用：";
        } catch (Exception e) {
            msg = "else >> "+ e.getCause();
            System.out.println("else -- >" + e.getCause());
        }
        /*// 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);*/
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
