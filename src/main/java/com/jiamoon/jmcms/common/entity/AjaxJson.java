package com.jiamoon.jmcms.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * ajax请求返回JSON对象
 */
@AllArgsConstructor
@NoArgsConstructor
public class AjaxJson<T> implements Serializable {
    /**
     * 请求结果代码
     */
    @Setter
    @Getter
    private int code;
    /**
     * 请求结果信息
     */
    @Setter
    @Getter
    private String msg;
    /**
     * 请求结果的错误代码
     */
    @Setter
    @Getter
    private String errorCode;
    /**
     * 请求结果的额外数据
     */
    @Setter
    @Getter
    private T data;
}
