package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import com.jiamoon.jmcms.common.entity.AjaxJson;
import com.jiamoon.jmcms.modules.admin.entity.DictType;
import com.jiamoon.jmcms.modules.admin.service.IDictTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

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
    public AjaxJson saveDictType(DictType dictType) {
        AjaxJson ajaxJson = new AjaxJson();
        if (StringUtils.isNotBlank(dictType.getId())) {
            //查询字典类型代码是否已经存在
            DictType dbDictType = dictTypeService.selectByPrimaryKey(dictType);
            if (null != dbDictType) {
                ajaxJson.setCode(1000);
                ajaxJson.setMsg("字典类型代码已存在！");
                return ajaxJson;
            }
        }
        ajaxJson.setCode(0);
        dictTypeService.save(dictType);
        return ajaxJson;
    }

    @ResponseBody
    @RequestMapping(value = "/data")
    public HashMap<String, Object> data(DictType dictType, @RequestParam(name = "pageIndex") int pageIndex,
                                        @RequestParam(name = "pageSize") int pageSize) {
        return dictTypeService.findList(dictType, pageIndex, pageSize);
    }
}
