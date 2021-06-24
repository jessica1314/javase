package com.zqh.day04;

/**
 * 懒汉式单例模式
 * 1.私有构造方法
 * 2.私有静态对象
 * 3.公有静态获取实例方法
 */
public class Single1 {
    private Single1() {

    }

    private static Single1 single = new Single1();

    public static Single1 getInstance() {
        return single;
    }

    public static void main(String[] args) {
        System.out.println(Single1.getInstance());
        System.out.println(Single1.getInstance());
    }
}
