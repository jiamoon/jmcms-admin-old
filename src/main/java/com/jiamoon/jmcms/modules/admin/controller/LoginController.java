package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("${jmcms.adminPath}")
public class LoginController extends BaseController {

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("sessionId", 1);
        model.addAttribute("username", 1);
        model.addAttribute("timeout", 1);
        model.addAttribute("userList", 1);
        return "/admin/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("id", subject.getSession().getId());
        System.out.println("来源  " + request.getRequestURI());
        //已经登录
        if (null != subject.getPrincipal()) {
        }
        return "/admin/login";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "登录成功";
    }
}
