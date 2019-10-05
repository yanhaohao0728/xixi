package com.qf.utils;

import java.util.Calendar;
import java.util.Random;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 19:37
 */
public class OddUtils {
    private OddUtils(){}
    public static String getOrderOdd() {
        Calendar c = Calendar.getInstance();
        Random r = new Random();
        // 随机数范围100000-999999
        int res = r.nextInt(900000) + 100000;

        // 获取当前年份、月份、日期
        String year = "" + c.get(Calendar.YEAR);
        String month = "" + (c.get(Calendar.MONTH) + 1);
        String date = "" + c.get(Calendar.DATE);
        String hour = "" + c.get(Calendar.HOUR_OF_DAY);
        String minute = "" + c.get(Calendar.MINUTE);
        String second = "" + c.get(Calendar.SECOND);
        return year + (month.length() > 1 ? month : "0" + month) + (date.length() > 1 ? date : "0" + date) + res;
    }
}
