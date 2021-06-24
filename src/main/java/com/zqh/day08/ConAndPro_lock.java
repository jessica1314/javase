package com.zqh.day08;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock显示锁 等同于synchronized 隐士锁
 * condition 等待唤醒条件  等价于 object里的wait notify notifyall
 * <p>
 * 线程停止运行，目的就是不让run里的代码继续跑下去！
 */
public class ConAndPro_lock {
    public static void main(String[] args) {
        Resource1 Resource1 = new Resource1();
        Producer1 pro1 = new Producer1(Resource1);
        new Thread(pro1, "pro-1").start();
        Producer1 pro2 = new Producer1(Resource1);
        new Thread(pro2, "pro-2").start();
        Consumer1 con1 = new Consumer1(Resource1);
        new Thread(con1, "con-1").start();
        Consumer1 con2 = new Consumer1(Resource1);
        new Thread(con2, "con-2").start();

//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        pro1.stop();
//        pro2.stop();
//        con1.stop();
//        con2.stop();
    }
}

class Resource1 {
    private boolean flag = true; //true：生产 false：消费
    private String name;
    Lock lock = new ReentrantLock();
    Condition con_pro = lock.newCondition();
    Condition con_con = lock.newCondition();

    //生产
    void set(String name) {
        lock.lock();
        try {
            //如果flag是false，等待被消费
            while (!flag) {
                try {
                    con_pro.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //就生产
            this.name = name;
            System.out.println(Thread.currentThread().getName() + "生产了--->" + name);
            flag = false;
            con_con.signalAll();//唤醒消费者
        } finally {
            lock.unlock();
        }

    }

    //消费
    void get() {
        lock.lock();
        try {
            while (flag) {
                try {
                    con_con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //消费
            System.out.println(Thread.currentThread().getName() + "消费了----------------->" + name);
            //通知生产线程！但不一定就唤醒生产！
            flag = true;
            con_pro.signalAll();
        } finally {
            lock.unlock();
        }

    }
}

class Producer1 implements Runnable {
    private Resource1 Resource1;
    static int x = 0;  //生产线程共享数！
    private boolean flag = true;

    Producer1(Resource1 Resource1) {
        this.Resource1 = Resource1;
    }

    @Override
    public void run() {
        while (flag) {
            if (x % 2 == 0) {
                Resource1.set("香蕉");
            } else {
                Resource1.set("苹果");
            }
            x++;
        }
    }

    public void stop() {
        flag = false;
    }
}

class Consumer1 implements Runnable {
    private Resource1 Resource1;
    private boolean flag = true;

    Consumer1(Resource1 Resource1) {
        this.Resource1 = Resource1;
    }

    @Override
    public void run() {
        while (flag) {
            Resource1.get();
        }
    }

    public void stop() {
        flag = false;
    }
}

