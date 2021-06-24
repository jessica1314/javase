package com.zqh.day0531;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        //启动线程 在java里面只有实例化thread类，调用start方法等待cpu执行调用
//        System.out.println("main start...");
//        Thread t = new Thread(() -> {
//            System.out.println("thread run...");
//            System.out.println("thread end.");
//        });
//        t.start();
//        //使得当前线程（main线程）休眠10s，不释放资源权利
////        Thread.sleep(1000);
//        t.join();//main线程等待t线程执行完任务后才执行自己的下面的代码？
//        System.out.println("main end...");
//        Thread t1 = new MyThread();

//        t1.start();//启动新线程 传入一个runnable实例！
//        new Thread(() -> {
//            System.out.println("start num 2 thread!");
//        }).start(); //启动任务
//      /*  MyThread t1 = new MyThread();
//        t1.start();
//        Thread.sleep(20);
//        t1.interrupt(); //通知t1线程中断任务吧
//        t1.join();//等待t1线程执行完毕！
//        System.out.println("end ");*}
        log("start main");
        new Thread(() -> {
            log("run task .....");
        }).start();

        new Thread(() -> {
            log("print....");
        }).start();

        log("main end ");

        MyThread t1 = new MyThread();
        t1.start();
        Thread.sleep(15);
        t1.running = false;
        //一个线程如何实现传递某一些参数，问题是传递状态值！例如 user对象，会导致所有的下级方法都会需要这个形参
        //在一个线程中，横跨若干方法调用需要传递对象，我们称为上下文
        //context，是一种状态，可以是用户身份、任务信息
        //给每个方法增加一个context参数很麻烦，有时候使用第三方的软件没办法修改源码，该对象无法传入
        //Java标准库提供了一个特殊的ThreadLocal，他可以实现在一个线程中传递同一个对象
        //

    }

    //让线程做点事儿！ run方法里？
    static class MyThread extends Thread {
        //可见性 对于其他线程 这里是主线程可见
        //每次访问该变量总是获取内存中最新值
        //修改这个变量，马上会写到主存中
        private volatile boolean running = true;

        @Override
        public void run() {
            int n = 0;
            while (running) {
                n++;
                System.out.println(Thread.currentThread().getName());
                System.out.println(n + "hello!");
            }
            System.out.println(" end! ");
        }
    }

    static void log(String name) {
        System.out.println(Thread.currentThread().getName() + ":" + name);
    }


}
