package com.jiamoon.jmcms.common.cookie;

import org.apache.shiro.web.servlet.SimpleCookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JmcmsSimpleCookie extends SimpleCookie {
    public JmcmsSimpleCookie(String name) {
        super(name);
    }

    @Override
    public String readValue(HttpServletRequest request, HttpServletResponse ignored) {
        //读取 SessionId，即 jwt 串
        String name = getName();
        System.out.println("读取Cookie:" + name);
        String value = request.getHeader(name);
        value = request.getParameter("token");
        return value;
    }
}
