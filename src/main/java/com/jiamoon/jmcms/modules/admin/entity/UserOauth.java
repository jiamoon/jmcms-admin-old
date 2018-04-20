package com.jiamoon.jmcms.modules.admin.entity;

import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Setter
@Getter
@Table(name = "sys_user_oauth")
public class UserOauth extends DataEntity<UserOauth> {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 认证类型
     */
    private String oauthType;
    /**
     * 认证账号
     */
    private String oauthAccount;
    /**
     * 认证密码
     */
    private String oauthPassword;
    /**
     * 是否已验证
     */
    private int verified;
}
