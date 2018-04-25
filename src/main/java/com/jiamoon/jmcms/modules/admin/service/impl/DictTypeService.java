package com.jiamoon.jmcms.modules.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiamoon.jmcms.common.entity.BaseEntity;
import com.jiamoon.jmcms.common.service.impl.BaseService;
import com.jiamoon.jmcms.common.util.Tools;
import com.jiamoon.jmcms.modules.admin.dao.DictTypeMapper;
import com.jiamoon.jmcms.modules.admin.entity.DictType;
import com.jiamoon.jmcms.modules.admin.service.IDictTypeService;
import com.sun.tools.javac.util.Assert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 字典service
 */
@Service
public class DictTypeService extends BaseService<DictTypeMapper, DictType> implements IDictTypeService {
    /**
     * 保存数据
     *
     * @param dictType
     * @return
     */
    @Override
    public int save(DictType dictType) {
        if (StringUtils.isBlank(dictType.getId())) {
            dictType.setId(Tools.getUUID());
            Date date = new Date();
            dictType.setCreateTime(date);
            dictType.setUpdateTime(date);
            return mapper.insertSelective(dictType);
        } else {
            dictType.setUpdateTime(new Date());
            return mapper.updateByPrimaryKeySelective(dictType);
        }
    }

    /**
     * 查询数据列表
     *
     * @return
     */
    @Override
    public HashMap<String, Object> findList(DictType dictType,int pageIndex,int pageSize) {
        Example example = new Example(DictType.class);
        example.setOrderByClause("sort asc");
        example.createCriteria().andEqualTo("delFlag", BaseEntity.DEL_FLAG_NORMAL);
        PageHelper.startPage(pageIndex, pageSize);
        List<DictType> list = mapper.selectByExample(example);
        PageInfo page = new PageInfo(list);
        return Tools.getBootstrapTableData(list, page.getTotal());
    }
}
