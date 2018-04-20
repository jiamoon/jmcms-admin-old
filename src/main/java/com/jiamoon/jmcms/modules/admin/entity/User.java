package com.jiamoon.jmcms.modules.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;

/**
 * 用户
 */
@Setter
@Getter
@Table(name = "sys_user")
public class User extends DataEntity<User> {
    /**
     * 用户编号
     */
    private int userNo;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 头像
     */
    private String profilePhoto;
    /**
     * 个性签名
     */
    private String sign;
    /**
     * 证件类型
     */
    private String idcardType;
    /**
     * 证件号码
     */
    private String idcard;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 注册ip
     */
    private String regIp;
    /**
     * 账号状态
     */
    private String status;
}
