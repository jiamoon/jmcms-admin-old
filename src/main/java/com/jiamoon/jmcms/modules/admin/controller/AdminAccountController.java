package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员账号Controller
 */
@Controller
@RequestMapping("${jmcms.adminPath}/account/admin")
public class AdminAccountController extends BaseController {

    @RequestMapping("")
    public String index() {
        return adminPath + "/account/admin/index";
    }
}
