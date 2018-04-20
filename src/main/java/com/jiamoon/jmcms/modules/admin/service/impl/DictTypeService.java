package com.jiamoon.jmcms.modules.admin.service.impl;

import com.jiamoon.jmcms.common.service.impl.BaseService;
import com.jiamoon.jmcms.common.util.Tools;
import com.jiamoon.jmcms.modules.admin.dao.DictTypeMapper;
import com.jiamoon.jmcms.modules.admin.entity.DictType;
import com.jiamoon.jmcms.modules.admin.service.IDictTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
