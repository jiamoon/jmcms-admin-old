package com.jiamoon.jmcms.modules.admin.entity;

import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 后台角色
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sys_admin_role")
public class AdminRoleBiz extends DataEntity<AdminRoleBiz>{
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色代码
     */
    private String roleCode;
    /**
     * 角色描述
     */
    private String role_desc;
    /**
     * 角色状态
     */
    private Integer status;
}
