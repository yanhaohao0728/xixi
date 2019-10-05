package com.qf.utils;

import java.util.Calendar;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 19:28
 */
public class TimeUtils {
    private TimeUtils(){}
    public static String getOrderTime() {
        Calendar c = Calendar.getInstance();
        // 获取当前年份、月份、日期
        String year = "" + c.get(Calendar.YEAR);
        String month = "" + (c.get(Calendar.MONTH) + 1);
        String date = "" + c.get(Calendar.DATE);
        return year +"-"+ (month.length() > 1 ? month : "0" + month)+"-" + (date.length() > 1 ? date : "0" + date);
    }
}
