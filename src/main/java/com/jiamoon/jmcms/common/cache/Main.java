package com.jiamoon.jmcms.common.cache;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //0.5秒

        float f = 0.1F;
        System.out.println((0.1F+0.1));
        System.out.println((0.1+0.1));
    }

    public static Object formatDate(long time) {
        if (time < 1000) {
            return (float)time / 1000 + "毫秒";
        }
        else if (time < 1000 * 60) {
            return time / 1000 + "秒";
        }
        else if (time < 1000 * 60 * 60) {
            return time / 1000 / 60 + "分钟";
        }
        else if (time < 1000 * 60 * 60 * 24) {
            return time / 1000 / 60 / 60 + "小时";
        }
        return time /1000 / 60 / 60 / 24 + "天";
    }
}
