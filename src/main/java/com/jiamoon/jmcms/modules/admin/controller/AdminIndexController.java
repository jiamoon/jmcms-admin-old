package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台首页Controller
 */
@Controller
@RequestMapping("${jmcms.adminPath}/")
public class AdminIndexController extends BaseController {

    @RequestMapping("windows")
    public String windows() {
        return adminPath + "/windows/index";
    }
}
