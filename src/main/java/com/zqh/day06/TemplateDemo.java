package com.zqh.day06;

/**
 * 需求：获取一段程序运行的时间
 * 原理：获取时间差,利用继承！
 * 模板方法设计模式？
 * 定义功能时 ，功能的一部分确定，一部分不确定，确定的部分在使用不确定的部分，这时把不确定的部分暴露出去
 * 由子类来实现！
 */
public class TemplateDemo {
    public static void main(String[] args) {
        GetTime time1 = new Subtime();
        time1.getTime();
    }
}

abstract class GetTime {
    public final  void getTime() {  //不可被子类覆写
        long start = System.currentTimeMillis();
        runcode(); //调用当前对象对应的方法
        long end = System.currentTimeMillis();
        System.out.println("毫秒数:\t" + (end - start));
    }

    public abstract void runcode();  //便于子类覆写
}

class Subtime extends GetTime {

    @Override
    public void runcode() {
        for (int i = 0; i < 4000; i++) {
            System.out.println(i);
        }
    }
}