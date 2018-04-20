package com.jiamoon.jmcms.common.service.impl;

import com.jiamoon.jmcms.common.dao.BaseMapper;
import com.jiamoon.jmcms.common.entity.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基类service层
 *
 * @param <M> mapper接口
 * @param <T> 数据实体类
 */
public class BaseService<M extends BaseMapper<T>, T extends DataEntity<T>> {
    @Autowired
    protected M mapper;

    public T selectByPrimaryKey(T t) {
        return mapper.selectByPrimaryKey(t);
    }

    public int insert(T t) {
        return mapper.insert(t);
    }
}
