package com.jiamoon.jmcms.common.service;

import com.jiamoon.jmcms.common.dao.BaseMapper;
import com.jiamoon.jmcms.common.entity.DataEntity;

public interface IBaseService<M extends BaseMapper<T>, T extends DataEntity<T>> {
    T selectByPrimaryKey(T t);
    int insert(T t);
}
