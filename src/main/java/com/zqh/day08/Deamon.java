package com.zqh.day08;

public class Deamon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("deamon1 启动。。。。。。。。。");

            }
        });

        thread.start();
        thread.join();// cpu让给谁来执行！
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("deamon2 启动。。。。。。。。。");

            }
        });
        t2.setDaemon(true);
        t2.start();
        for (int i = 0; i < 10; i++) { //守护进程只要主线程结束就结束了！
            System.out.println("main\t" + i);
        }
    }

}

