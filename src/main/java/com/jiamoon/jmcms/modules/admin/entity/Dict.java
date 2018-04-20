package com.jiamoon.jmcms.modules.admin.entity;

import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 字典实体类
 */
@Setter
@Getter
@Table(name = "sys_dict")
public class Dict extends DataEntity<Dict> {
    /**
     * 字典类型
     */
    @Transient
    private DictType dictType;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 字典代码
     */
    private String dictCode;
}
