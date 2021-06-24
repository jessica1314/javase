package com.zqh.day06;

/*
特殊的抽象类，都是抽象方法，
1.接口中常用定义：常量和抽象方法
2.成员的固定修饰符
    常量：public static final
    方法：public abstract

3.接口只能被实现，接口中的抽象方法需要实现完才能使用
4.接口不能被实例化
5.接口被类去多实现！
6.接口间可以多继承！
 */
public interface InterfaceDemo {
     int NUM = 0;
    void show();

    public static void main(String[] args) {
        System.out.println(SubInterface.NUM);
        System.out.println(InterfaceDemo.NUM);
    }
}

class SubInterface implements InterfaceDemo {
    @Override
    public void show() {
        System.out.println("我是实现接口的子类");
    }
}
