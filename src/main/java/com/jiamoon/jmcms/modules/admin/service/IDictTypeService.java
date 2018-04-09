package com.jiamoon.jmcms.modules.admin.service;

import com.jiamoon.jmcms.modules.admin.entity.DictType;

/**
 * 字典service接口
 */
public interface IDictTypeService {
    /**
     * 插入一条数据
     *
     * @param dictType
     * @return
     */
    int insert(DictType dictType);

    /**
     * 动态插入一条数据
     *
     * @param dictType
     * @return
     */
    int insertSelective(DictType dictType);

    /**
     * 根据主键修改数据
     *
     * @param dictType
     * @return
     */
    int updateByPrimaryKey(DictType dictType);

    /**
     * 根据主键动态修改数据
     *
     * @param dictType
     * @return
     */
    int updateByPrimaryKeySelective(DictType dictType);

    /**
     * 根据主键删除数据
     *
     * @param dictType
     * @return
     */
    int deleteByPrimaryKey(DictType dictType);

    /**
     * 删除数据
     *
     * @param dictType
     * @return
     */
    int delete(DictType dictType);

    /**
     * 保存数据(自动判断是新增还是修改)
     *
     * @param dictType
     * @return
     */
    int save(DictType dictType);
}
