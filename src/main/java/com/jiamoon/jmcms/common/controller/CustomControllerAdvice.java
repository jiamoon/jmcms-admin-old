package com.jiamoon.jmcms.common.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object test(Exception e) {
        e.printStackTrace();
        return "错误\n" + e.getMessage();
    }
}
