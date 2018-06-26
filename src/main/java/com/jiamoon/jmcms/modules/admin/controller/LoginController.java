package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import com.jiamoon.jmcms.common.dao.RedisDao;
import com.jiamoon.jmcms.common.dao.RedisSessionDao;
import com.jiamoon.jmcms.common.util.DateUtil;
import com.jiamoon.jmcms.common.util.Tools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

import static com.jiamoon.jmcms.common.dao.RedisSessionDao.SHIRO_REDIS_SESSION_PRE;

@Controller
@RequestMapping("${jmcms.adminPath}")
public class LoginController extends BaseController {
    @Autowired
    RedisSessionDao redisSessionDao;
    @Autowired
    RedisDao redisDao;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String index(Model model,HttpServletRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("sessionId", subject.getSession().getId());
        model.addAttribute("username", subject.getPrincipal());
        model.addAttribute("timeout", subject.getSession().getTimeout());
        model.addAttribute("timeoutFormat", DateUtil.formatMsDate(subject.getSession().getTimeout()));
        model.addAttribute("start", dateFormat.format(subject.getSession().getStartTimestamp()));
        model.addAttribute("last", dateFormat.format(subject.getSession().getLastAccessTime()));
        model.addAttribute("password", subject.getPrincipals());
        model.addAttribute("userList", redisSessionDao.readSession(subject.getSession().getId()).getTimeout());
        long redisExpire = redisDao.getRedisTemplate().getExpire(SHIRO_REDIS_SESSION_PRE + subject.getSession().getId());
        model.addAttribute("redis", DateUtil.formatMsDate(redisExpire * 1000));
        model.addAttribute("ip", Tools.getIpAddr(request));
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
