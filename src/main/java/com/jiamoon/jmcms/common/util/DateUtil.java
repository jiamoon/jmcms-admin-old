package com.jiamoon.jmcms.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {
    /**
     * 毫秒格式化显示
     *
     * @param time
     * @return
     */
    public static String formatMsDate(long time) {
        if (time < 1000) {
            return (float) time / 1000 + "毫秒";
        } else if (time < 1000 * 60) {
            return time / 1000 + "秒";
        } else if (time < 1000 * 60 * 60) {
            return time / 1000 / 60 + "分钟";
        } else if (time < 1000 * 60 * 60 * 24) {
            return time / 1000 / 60 / 60 + "小时";
        }
        return time / 1000 / 60 / 60 / 24 + "天";
    }

    /**
     * 格式化指定时间
     *
     * @param date    需要格式化的时间
     * @param pattern 格式化规则
     * @return
     */
    public static String getTime(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化当前时间
     *
     * @param pattern 格式化规则
     * @return
     */
    public static String getTime(String pattern) {
        return getTime(new Date(), pattern);
    }

    /**
     * 格式化当前时间,用默认的格式化规则
     *
     * @return
     */
    public static String getTime() {
        return getTime("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化指定日期
     *
     * @param date    需要格式化的日期
     * @param pattern 格式化规则
     * @return
     */
    public static String getDate(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 格式化当前日期
     *
     * @param pattern 格式化规则
     * @return
     */
    public static String getDate(String pattern) {
        return getDate(new Date(), pattern);
    }

    /**
     * 格式化当前日期,用默认的格式化规则
     *
     * @return
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }
}
