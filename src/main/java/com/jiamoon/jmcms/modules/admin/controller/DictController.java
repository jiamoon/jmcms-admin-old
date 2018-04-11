package com.jiamoon.jmcms.modules.admin.controller;

import com.jiamoon.jmcms.common.controller.BaseController;
import com.jiamoon.jmcms.common.entity.AjaxJson;
import com.jiamoon.jmcms.modules.admin.dao.DictTypeMapper;
import com.jiamoon.jmcms.modules.admin.entity.DictType;
import com.jiamoon.jmcms.modules.admin.service.IDictTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 数据字典controller
 */
@RequestMapping("${jmcms.adminPath}/dict")
@Controller
public class DictController extends BaseController {
    @Autowired
    DictTypeMapper dictTypeMapper;
    @Autowired
    IDictTypeService dictTypeService;


    @RequestMapping("/dictTypeForm")
    public String dictTypeForm() {
        return "admin/dictTypeForm";
    }

    @RequestMapping(value = {"list", ""})
    public String test() {
        return "admin/dict/dictTypeList";
    }

    @ResponseBody
    @RequestMapping("/save")
    public Object save(DictType dictType) {
        if (StringUtils.isBlank(dictType.getTypeName())) {
            return new AjaxJson(-1, "字典类型名称不能为空！");
        } else if (StringUtils.isBlank(dictType.getTypeCode())) {
            return new AjaxJson(-1, "字典类型代码不能为空！");
        } else {
            //查询数据库中是否存在相同的字典类型代码
            Example example = new Example(DictType.class);
            example.createCriteria().andEqualTo("typeCode", dictType.getTypeCode());
            if (StringUtils.isNotBlank(dictType.getId())) {
                example.and().andNotEqualTo("id", dictType.getId());
            }
            List<DictType> dictTypeList = dictTypeMapper.selectByExample(example);
            //字典类型代码重复
            if (dictTypeList.size() > 0) {
                return new AjaxJson(-1, "字典类型代码已存在！");
            } else {
                int saveResult = dictTypeService.save(dictType);
                if (saveResult > 0) {
                    return new AjaxJson(0, "字典类型保存成功！");
                } else {
                    return new AjaxJson(-1, "字典类型保存失败！");
                }
            }
        }
    }
}
