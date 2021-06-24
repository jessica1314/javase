package com.zqh.day08;

public class ConAndPro {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread t1 = new Thread(new Producer(resource), "pro-1");
        t1.setDaemon(true);
        t1.start();
        Thread t2 = new Thread(new Producer(resource), "pro-2");
        t2.setDaemon(true);
        t2.start();
        Thread t3 = new Thread(new Consumer(resource), "con-1");
        t3.setDaemon(true);
        t3.start();
        Thread t4 = new Thread(new Consumer(resource), "con-2");
        t4.setDaemon(true);
        t4.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main.....");
        }
    }
}

class Resource {
    private boolean flag = true; //true：生产 false：消费
    private String name;

    //生产
    synchronized void set(String name) {
        //如果flag是false，等待被消费
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //就生产
        this.name = name;
        System.out.println(Thread.currentThread().getName() + "生产了--->" + name);
        flag = false;
        notifyAll();//唤醒消费者
    }

    //消费
    synchronized void get() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费
        System.out.println(Thread.currentThread().getName() + "消费了----------------->" + name);
        //通知生产线程！但不一定就唤醒生产！
        flag = true;
        notifyAll();
    }
}

class Producer implements Runnable {
    private Resource resource;
    static int x = 0;  //生产线程共享数！

    Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        while (true) {
            if (x % 2 == 0) {
                resource.set("香蕉");
            } else {
                resource.set("苹果");
            }
            x++;
        }
    }
}

class Consumer implements Runnable {
    private Resource resource;

    Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            resource.get();
        }
    }
}

