package com.jiamoon.jmcms.modules.admin.entity;

import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 字典类型实体类
 */
@Table(name = "dict_type")
public class DictType extends DataEntity<DictType> {
    /**
     * 字典类别名称
     */
    @Setter
    @Getter
    private String typeName;
    /**
     * 字典类别代码
     */
    @Setter
    @Getter
    private String typeCode;
}
