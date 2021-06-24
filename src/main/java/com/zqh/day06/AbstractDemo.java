package com.zqh.day06;

/**
 * 测试抽象类的功能，
 * 抽象方法里可以定义抽象方法(提取子类公有的方法但是实现肯定不同，所以就抽取到父类定义为抽象)，由子类来具体实现方法，
 */
public class AbstractDemo {
    public static void main(String[] args) {
        Student s = new BaseStudnet(1);
        s.study();
        s.show();
        System.out.println(s.getNum());
        Student s2 = new Advstudent(2);
        s2.study();
        s2.show();
        System.out.println(s2.getNum());

    }
}

abstract class Student {
    private int num = 0;

    abstract void study();  //让子类去自己实现此抽象方法具体内容，模糊的不具体的

    void show() {
        System.out.println("我是抽象类中的对象方法。。。。。。。");
    }

    public Student(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }
}

class BaseStudnet extends Student {
    BaseStudnet(int num) {
        super(num);
    }

    @Override
    void study() {
        System.out.println("base study................");
    }
}

class Advstudent extends Student {
    Advstudent(int num) {
        super(num);
    }

    @Override
    void study() {
        System.out.println("adv study................");
    }
}

class ChongCiStudent extends Student {

    ChongCiStudent(int num) {
        super(num);
    }

    @Override
    void study() {
        System.out.println("冲刺班。。。。。。。。。。。。。。");
    }
}
