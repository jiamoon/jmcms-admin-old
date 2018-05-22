package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping("${jmcms.adminPath}")
public class LoginController extends BaseController {
    @Autowired
    private SessionDAO sessionDAO;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("sessionId", SecurityUtils.getSubject().getSession().getId());
        model.addAttribute("username", SecurityUtils.getSubject().getPrincipal());
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            System.out.println("登录ip:" + session.getHost());
            //System.out.println("登录用户"+session.getAttribute(DefaultWebContext.PRINCIPALS_SESSION_KEY));
            System.out.println("最后操作日期:" + session.getLastAccessTime());
        }
        System.out.println(sessionDAO.getActiveSessions());
        model.addAttribute("userList", sessionDAO.getActiveSessions().toArray());
        return "/admin/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
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
        return "/admin/login";
    }
}
