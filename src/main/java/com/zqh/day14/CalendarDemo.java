package com.zqh.day14;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CalendarDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print((new Random().nextInt(10) + 1) + ",");
        }
        System.out.println("=================");
        System.out.println((int) Math.random() * 10 + 1);  //[0,1)*10= [0,10)+1=[1,10]
    }


    private static void method01() {
        Date date = new Date();
        final Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.get(Calendar.YEAR) + "年"
                + instance.get(Calendar.MONTH) + "月"
                + instance.get(Calendar.DATE) + "日"
                + "星期" + (instance.get(Calendar.DAY_OF_WEEK) - 1));

        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf.format(date));//日期格式化为字符串-format；字符串格式为date-parse
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.random());
    }
}
