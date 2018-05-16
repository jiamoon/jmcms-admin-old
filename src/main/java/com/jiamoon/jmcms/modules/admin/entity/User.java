package com.jiamoon.jmcms.modules.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;

/**
 * 账号基础信息表
 */
@Table(name = "sys_user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends DataEntity<User> {
    /**
     * 用户编码
     */
    private Integer userCode;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 个性签名
     */
    private String sign;
    /**
     * 注册IP
     */
    private String regIp;
    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regTime;
    /**
     * 最后注册IP
     */
    private String lastLoginIp;
    /**
     * 最后注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    /**
     * 账号状态(1、正常；-1、账号已禁用；)
     */
    private Integer status;
}
