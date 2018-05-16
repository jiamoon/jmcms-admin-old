package com.jiamoon.jmcms.common.service.impl;

import com.jiamoon.jmcms.common.dao.BaseMapper;
import com.jiamoon.jmcms.common.entity.DataEntity;
import com.jiamoon.jmcms.common.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<M extends BaseMapper<T>,T extends DataEntity<T>> implements IBaseService<T> {
    @Autowired
    protected M mapper;

    @Override
    public List<T> select(T entity) {
        return mapper.select(entity);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(T record) {
        return 0;
    }

    @Override
    public int insertSelective(T record) {
        return 0;
    }

    @Override
    public T selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return 0;
    }
}
