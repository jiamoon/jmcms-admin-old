package com.jiamoon.jmcms.common.service;

import com.jiamoon.jmcms.common.util.Tools;
import com.jiamoon.jmcms.common.dao.BaseMapper;
import com.jiamoon.jmcms.common.entity.DataEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 基类service层
 *
 * @param <M> mapper接口
 * @param <T> 数据实体类
 */
public abstract class BaseService<M extends BaseMapper<T>, T extends DataEntity<T>> {
    @Autowired
    M mapper;

    /**
     * 插入一条数据
     *
     * @param t
     * @return
     */
    public int insert(T t) {
        t.setCreateTime(new Date());
        return mapper.insert(t);
    }

    /**
     * 动态插入一条数据
     *
     * @param t
     * @return
     */
    public int insertSelective(T t) {
        t.setCreateTime(new Date());
        return mapper.insertSelective(t);
    }

    /**
     * 根据主键修改数据
     *
     * @param t
     * @return
     */
    public int updateByPrimaryKey(T t) {
        t.setUpdateTime(new Date());
        return mapper.updateByPrimaryKey(t);
    }

    /**
     * 根据主键动态修改数据
     *
     * @param t
     * @return
     */
    public int updateByPrimaryKeySelective(T t) {
        t.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据主键删除数据
     *
     * @param t
     * @return
     */
    public int deleteByPrimaryKey(T t) {
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * 删除数据
     *
     * @param t
     * @return
     */
    public int delete(T t) {
        return mapper.delete(t);
    }

    /**
     * 保存数据(自动判断是新增还是修改)
     *
     * @param t
     * @return
     */
    public int save(T t) {
        if (StringUtils.isBlank(t.getId())) {
            t.setId(Tools.getUUID());
            Date date = new Date();
            t.setCreateTime(date);
            t.setUpdateTime(date);
            return mapper.insertSelective(t);
        } else {
            t.setUpdateTime(new Date());
            return mapper.updateByPrimaryKeySelective(t);
        }
    }
}
