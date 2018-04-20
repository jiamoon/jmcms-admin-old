package com.jiamoon.jmcms.modules.admin.entity;

import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * 内部账号
 */
@Setter
@Getter
@Table(name = "sys_admin")
public class Admin extends DataEntity<Admin> {
    /**
     * 账号基础信息
     */
    @Transient
    private User user;
    /**
     * 授权信息列表
     */
    @Transient
    private List<UserOauth> oauthList;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 入职日期
     */
    private String hiredate;
}
