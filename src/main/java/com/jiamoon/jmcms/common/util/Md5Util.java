package com.jiamoon.jmcms.common.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5工具类
 */
public class Md5Util {
    /**
     * md5加密
     * @param content 需要加密的内容
     * @return
     * @throws NoSuchAlgorithmException 没有这种加密方法
     * @throws UnsupportedEncodingException 不支持的编码格式
     */
    public static String encode(String content){
        //确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            return new String(md5.digest(content.getBytes("utf-8")),"utf-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
