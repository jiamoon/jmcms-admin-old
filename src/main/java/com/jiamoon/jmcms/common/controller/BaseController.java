package com.jiamoon.jmcms.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * 基类控制器
 */
public class BaseController {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Value(value = "${jmcms.adminPath}")
    public String adminPath;
    @Value(value = "${jmcms.productName}")
    public String productName;
}
