package com.jiamoon.jmcms.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 */
public class BaseEntity<T> implements Serializable {
    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final int DEL_FLAG_NORMAL = 0;
    public static final int DEL_FLAG_DELETE = 1;
    public static final int DEL_FLAG_AUDIT = 2;

    /**
     * 实体编号（唯一标识）
     */
    @Setter
    @Getter
    private String id;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Setter
    @Getter
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Setter
    @Getter
    private Date updateTime;

    /**
     * 删除标记
     */
    @Setter
    @Getter

    private int delFlag;
    /**
     * 备注
     */
    @Setter
    @Getter
    private String remarks;

    public BaseEntity() {
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public BaseEntity(String id) {
        this.id = id;
        this.delFlag = DEL_FLAG_NORMAL;
    }
}
