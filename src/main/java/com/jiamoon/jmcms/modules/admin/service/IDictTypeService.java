package com.jiamoon.jmcms.modules.admin.service;

import com.jiamoon.jmcms.common.service.IBaseService;
import com.jiamoon.jmcms.modules.admin.dao.DictTypeMapper;
import com.jiamoon.jmcms.modules.admin.entity.DictType;

/**
 * 字典service接口
 */
public interface IDictTypeService extends IBaseService<DictTypeMapper,DictType> {
    /**
     * 保存数据
     * @param dictType
     * @return
     */
    int save(DictType dictType);
}
