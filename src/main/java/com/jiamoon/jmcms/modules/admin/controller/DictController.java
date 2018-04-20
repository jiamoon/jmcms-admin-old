package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import com.jiamoon.jmcms.modules.admin.entity.DictType;
import com.jiamoon.jmcms.modules.admin.service.IDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 数据字典controller
 */
@RequestMapping("${jmcms.adminPath}/dict")
@Controller
public class DictController extends BaseController {
    @Autowired
    IDictTypeService dictTypeService;

    /**
     * 字典类别表单
     *
     * @param dictType
     * @param model
     * @return
     */
    @RequestMapping("/type/form")
    public String typeForm(DictType dictType, Model model) {
        return "admin/dict/type/form";
    }

    /**
     * 字典类别列表
     *
     * @return
     */
    @RequestMapping(value = {"", "/list"})
    public String list() {
        return "admin/dict/list";
    }

    @ResponseBody
    @RequestMapping("/type/save")
    public void saveDictType(DictType dictType) {
        dictTypeService.save(dictType);
    }
}
