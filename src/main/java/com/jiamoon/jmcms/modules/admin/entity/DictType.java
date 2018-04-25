package com.jiamoon.jmcms.modules.admin.entity;

import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 字典类型实体类
 */
@Setter
@Getter
@Table(name = "sys_dict_type")
public class DictType extends DataEntity<DictType> {
    /**
     * 字典类型名称
     */
    @NotNull(message = "字典类型名称不能为空！")
    private String typeName;
    /**
     * 字典类型代码
     */
    @NotNull(message = "字典类型代码不能为空！")
    private String typeCode;
    /**
     * 排序
     */
    private int sort = 1;
    /**
     * 状态(1、为正常，0为禁用)
     */
    private int status = 1;
}
