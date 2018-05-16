package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.modules.admin.entity.User;
import com.jiamoon.jmcms.modules.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/api")
@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping("")
    public Object test(@RequestHeader("Host") String host, HttpServletRequest request) {
        User user = new User();
        user.setUsername("admin");
        return request.getCookies();
    }
}
