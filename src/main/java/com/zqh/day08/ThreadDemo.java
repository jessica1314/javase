package com.zqh.day08;

/**
 * @author JESSICA
 * @version 1.01
 * @
 * @since 2020年12月1日 20:57:58
 */
public class ThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            //启动了5个线程来争抢cpu的资源，随机的
            // 可以考虑同时争抢共享资源呢？ 给资源（对象化）上锁？ 例如：对其内部方法上锁？ 保证同步，
            // 有一个线程持有这个对象锁了，其他线程只能堵塞等待锁释放去争夺，
            //  何为排他写，共享读？
            new Thread(new A("thread ->" + i)).start();
        }
    }
}

//线程类？去处理任务？ 如果需要争抢资源就传入资源对象！
class A implements Runnable {
    private final String name;

    //线程类，执行了 ，执行的内容？
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是线程类" + Thread.currentThread().getName() + "\t正在执行。。。");
        }
    }

    public A(String name) {
        this.name = name;
    }
}
