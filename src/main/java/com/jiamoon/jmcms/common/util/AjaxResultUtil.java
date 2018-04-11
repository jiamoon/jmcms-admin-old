package com.jiamoon.jmcms.common.util;

import com.jiamoon.jmcms.common.entity.AjaxJson;

/**
 * ajax请求返回工具
 */
public class AjaxResultUtil {
    /**
     * 请求成功
     * @return
     */
    public static AjaxJson success() {
        return success(null,"操作成功！");
    }

    /**
     * 请求成功
     * @param data 请求结果返回的数据
     * @param msg 结果信息
     * @return
     */
    public static AjaxJson success(Object data, String msg) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setCode(200);
        ajaxJson.setMsg(msg);
        ajaxJson.setData(data);
        return ajaxJson;
    }

    /**
     * 请求失败
     * @param code 结果代码
     * @return
     */
    public static AjaxJson failed(int code) {
        return failed(code,"操作失败！","");
    }

    /**
     * 请求失败
     * @param code 结果代码
     * @param msg 结果信息
     * @param errorCode 错误代码
     * @return
     */
    public static AjaxJson failed(int code, String msg, String errorCode) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setCode(code);
        ajaxJson.setMsg(msg);
        return ajaxJson;
    }

    /**
     * 系统错误返回
     * @param errorCode 错误代码
     * @return
     */
    public static AjaxJson systemError(String errorCode) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setCode(500);
        ajaxJson.setMsg("系统错误，请联系管理员！");
        return ajaxJson;
    }
}
