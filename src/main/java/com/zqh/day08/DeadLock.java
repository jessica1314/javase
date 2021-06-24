package com.zqh.day08;

public class DeadLock {
    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (a.class) {
                System.out.println("获取a等待b");
                synchronized (b.class) {
                    System.out.println("b");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (b.class) {
                System.out.println("获取b等待a");
                synchronized (a.class) {
                    System.out.println("a");
                }
            }
        }).start();
    }
}

class a {
}

class b {
}


