package com.jiamoon.jmcms.modules.admin.service;

import com.jiamoon.jmcms.common.service.IBaseService;
import com.jiamoon.jmcms.modules.admin.dao.DictTypeMapper;
import com.jiamoon.jmcms.modules.admin.entity.DictType;

import java.util.HashMap;
import java.util.List;

/**
 * 字典service接口
 */
public interface IDictTypeService extends IBaseService<DictTypeMapper, DictType> {
    /**
     * 保存数据
     *
     * @param dictType
     * @return
     */
    int save(DictType dictType);

    /**
     * 查询数据列表
     *
     * @return
     */
    HashMap<String,Object> findList(DictType dictType,int pageIndex,int pageSize);
}
