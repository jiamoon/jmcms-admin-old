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
     * 请求结果的额外数据
     */
    @Setter
    @Getter
    private T data;

    public AjaxJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 设置错误信息
     * @param apiCode
     */
    public void setError(IApiCode apiCode) {
        code = apiCode.getCode();
        msg = apiCode.getMsg();
    }
}
