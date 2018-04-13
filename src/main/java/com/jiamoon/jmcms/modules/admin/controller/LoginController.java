package com.jiamoon.jmcms.modules.admin.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DelegatingSubject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台登录
 */
@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/ajaxLogin")
    public Object ajaxLogin(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");
        subject.login(token);
        System.out.println(WebUtils.getSavedRequest(request));
        
        //String url = WebUtils.getSavedRequest(request).getRequestUrl();
        return 123;
    }

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/login")
    public  String login(){
        return "admin/login";
    }
    @RequestMapping("/noLogin")
    public  String noLogin(){
        return "admin/noLogin";
    }
}
