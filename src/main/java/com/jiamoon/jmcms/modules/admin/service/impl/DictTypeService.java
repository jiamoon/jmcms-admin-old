package com.jiamoon.jmcms.modules.admin.service.impl;

import com.jiamoon.jmcms.common.service.BaseService;
import com.jiamoon.jmcms.modules.admin.dao.DictTypeMapper;
import com.jiamoon.jmcms.modules.admin.entity.DictType;
import com.jiamoon.jmcms.modules.admin.service.IDictTypeService;
import org.springframework.stereotype.Service;

/**
 * 字典service
 */
@Service
public class DictTypeService extends BaseService<DictTypeMapper, DictType> implements IDictTypeService {

    /**
     * 插入一条数据
     *
     * @param dictType
     * @return
     */
    public int insert(DictType dictType) {
        return super.insert(dictType);
    }

    /**
     * 动态插入一条数据
     *
     * @param dictType
     * @return
     */
    public int insertSelective(DictType dictType) {
        return super.insertSelective(dictType);
    }

    /**
     * 根据主键修改数据
     *
     * @param dictType
     * @return
     */
    public int updateByPrimaryKey(DictType dictType) {
        return super.updateByPrimaryKey(dictType);
    }

    /**
     * 根据主键动态修改数据
     *
     * @param dictType
     * @return
     */
    public int updateByPrimaryKeySelective(DictType dictType) {
        return super.updateByPrimaryKeySelective(dictType);
    }

    /**
     * 根据主键删除数据
     *
     * @param dictType
     * @return
     */
    public int deleteByPrimaryKey(DictType dictType) {
        return super.deleteByPrimaryKey(dictType);
    }

    /**
     * 删除数据
     *
     * @param dictType
     * @return
     */
    public int delete(DictType dictType) {
        return super.delete(dictType);
    }

    /**
     * 保存数据(自动判断是新增还是修改)
     *
     * @param dictType
     * @return
     */
    public int save(DictType dictType) {
        return super.save(dictType);
    }
}
