package com.jiamoon.jmcms.modules.admin.entity;

import com.jiamoon.jmcms.common.entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.List;

/**
 * 后台账号表
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends DataEntity<Admin> {
    /**
     * 账号基础信息
     */
    @Transient
    private User user;
    /**
     * 第三方账号授权信息
     */
    @Transient
    private List<UserAuth> authList;
    private String userId;
}
