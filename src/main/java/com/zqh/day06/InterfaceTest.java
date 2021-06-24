package com.zqh.day06;

/**
 * smoke这个功能不是公有的，所以需要定义在接口中
 * 基本功能和扩展功能？
 * 组织? 组织里干点副业？ 体系中不具备
 */
public interface InterfaceTest {
    public static void main(String[] args) {
        ZhangSan zhangSan = new ZhangSan();
        zhangSan.smoke();
    }
}

abstract class Stu {
    abstract void study();

    void sleep() {
        System.out.println("sleep");
    }

}

interface Smoking {
    void smoke();
}

class ZhangSan extends Stu implements Smoking {
    @Override
    public void smoke() {
        System.out.println("实现接口的抽烟功能");
    }

    @Override
    void study() {
        System.out.println("张三在学习。。。。");
    }

}

class Lisi extends Stu {

    @Override
    void study() {
        System.out.println("lisi在学习。。。");
    }

}