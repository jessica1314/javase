package com.zqh.day04;

/**
 * 懒汉式
 * 等到需要实例时才去构造出对象
 */
public class Single2 {
    private static int num = 0;

    private Single2() {
        num++;
    }

    private static Single2 single = null;

    public static Single2 getInstance() {
        if (single == null) {
            single = new Single2();
            System.out.println("================:   " + num);
        }
        return single;
    }

    public static void main(String[] args) {
        System.out.println("1:\t " + Single2.getInstance());
        System.out.println("======================");
        System.out.println("2:\t" + Single2.getInstance());
    }
}
