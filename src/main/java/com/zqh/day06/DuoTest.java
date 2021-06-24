package com.zqh.day06;

/**
 * 基础班：学习 睡觉
 * 高级班：学习 睡觉
 * 对以上2类事物进行抽取
 */
public class DuoTest {
    public static void main(String[] args) {
        DuoTest.doSomething(new BaseStu());//代码运行时看传入的对象实际类型！来执行特有方法
        DuoTest.doSomething(new AdvStu());
    }

    //调用方接受父类student1对象引用即可，提高代码扩展性
    private static void doStudent(Student1 student1) {
        student1.study();
        student1.sleep();
    }

    /**
     * @param student1 将学生这个父类作为形参传入
     */
    public static void doSomething(Student1 student1) {
        student1.sleep();
        student1.study();
    }
}


abstract class Student1 {
    public abstract void study();

    public void sleep() {
        System.out.println("学生躺着睡。。。");
    }
}

class BaseStu extends Student1 {
    @Override
    public void study() {
        System.out.println("基础班学习。。。。。。");
    }

    public void sleep() {
        System.out.println("基础班学生躺着睡觉。。。。。。。。。");
    }
}

class AdvStu extends Student1 {
    @Override
    public void study() {
        System.out.println("提高班学习、。。。。。。。。。。。");
    }
}


