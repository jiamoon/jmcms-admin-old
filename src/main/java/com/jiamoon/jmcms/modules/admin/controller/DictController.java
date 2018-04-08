package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import com.jiamoon.jmcms.modules.admin.dao.DictTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 数据字典controller
 */
@RequestMapping("${jmcms.adminPath}/dict")
@Controller
public class DictController extends BaseController {
    @Autowired
    DictTypeMapper dictTypeMapper;

    @RequestMapping("/dictTypeForm")
    public String dictTypeForm() {
        return "admin/dictTypeForm";
    }

    @ResponseBody
    @RequestMapping("/t")
    public Object t() {
        return dictTypeMapper.selectAll();
    }
}
