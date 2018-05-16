package com.jiamoon.jmcms.common.service;

import java.util.List;

public interface IBaseService<T> {
    List<T> select(T record);

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
