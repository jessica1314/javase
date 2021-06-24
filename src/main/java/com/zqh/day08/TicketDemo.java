package com.zqh.day08;

/**
 * 使用2个线程的2种方式来卖票100张
 * 一种是同步代码块
 * 一种是同步函数
 */
public class TicketDemo {
    public static void main(String[] args) {
        Ticket t1 = new Ticket();
        Thread one = new Thread(t1, "one");
        Thread two = new Thread(t1, "two");
        one.start(); //就绪状态，争夺到cpu可执行
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.flag = false;
        two.start();
    }
}

class Ticket implements Runnable {
    private static int sum = 100;
    boolean flag = true; //切换代码执行流程
    Object obj = new Object();

    @Override
    public void run() {
        if (flag) {
            while (true) {
                //同步静态方法就是锁当前的类字节码文件对象！
                synchronized (obj) {
                    synchronized (this) {
                        if (sum > 0) {
                            try {
                                //释放争夺当前cpu资源，如果持有锁，不释放，所以其他的线程无法进入同步代码块
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + "卖票" + sum--);
                        }
                    }
                }
            }
        } else {
            while (true)
                sale();
        }
    }

    //买票,同步函数锁的是当前对象
    private synchronized void sale() {
        synchronized (obj) {
            if (sum > 0) {
                try {
                    //释放争夺当前cpu资源，如果持有锁，不释放，所以其他的线程无法进入同步代码块
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票" + sum--);
            }
        }
    }

}
