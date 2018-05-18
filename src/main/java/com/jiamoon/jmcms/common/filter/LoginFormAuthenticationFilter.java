package com.jiamoon.jmcms.common.filter;

import com.jiamoon.jmcms.common.util.JmWebUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {
    /**
     * 表示当访问拒绝时
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("onAccessDenied:" + ((HttpServletRequest) request).getRequestURI());
        //如果是登录请求，也就是当前访问的是登录界面
        if (this.isLoginRequest(request, response)) {
            System.out.println("我是登录页面请求");
            if (this.isLoginSubmission(request, response)) {
                System.out.println("登录界面执行登录！！！");
                return this.executeLogin(request, response);
            } else {
                System.out.println("111");
                return true;
            }
        } else {
            System.out.println("未登录");
            this.saveRequestAndRedirectToLogin(request, response);
            return false;
        }
        //return super.onAccessDenied(request, response);
    }

    /**
     * 当登录成功
     *
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (!JmWebUtils.isAjax(request)) {// 不是ajax请求
            System.out.println("啊啊啊啊啊啊");
            issueSuccessRedirect(request, response);
        } else {
            System.out.println("当前是ajax");
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.println("{\"success\":true,\"message\":\"登入成功\"}");
            out.flush();
            out.close();
        }
        return false;
    }

    /**
     * 当登录失败
     *
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        return super.onLoginFailure(token, e, request, response);
    }
}
