package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import com.jiamoon.jmcms.common.entity.AjaxJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 管理员角色Controller
 */
@Controller
@RequestMapping("${jmcms.adminPath}/role/admin")
public class AdminRoleController extends BaseController {

    @RequestMapping("")
    public String index() {
        return adminPath + "/role/admin/index";
    }

    @RequestMapping("form")
    public String form() {
        return adminPath + "/role/admin/form";
    }

    @ResponseBody
    @RequestMapping("1")
    public Object test1() {
        return new AjaxJson<Object>(1, "错误");
    }

    @ResponseBody
    @RequestMapping("2")
    public Object test2() {
        return new AjaxJson<Object>(100, "正确");
    }
}
