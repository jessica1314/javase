package com.zqh.day05;


/**
 * final：最终，一个修饰符
 * 1，修饰类 方法 变量
 * 2.final修饰的类不可以继承(破坏了封装的特性，对外暴露啦)
 * 3.final修饰方法不能被覆写
 * 4.final修饰的变量(成员变量和局部变量)不可以被修改,只能被复制一次;,为了增加可阅读性！一般都是大写字母表示变量，多个用_连接，
 * 举例：常见变量：final double PI=3.1415926
 * 内部类定义在类中的局部位置上时，只能访问该局部被final修饰的局部变量
 */
public class FinalDemo {
    public static void main(String[] args) {
        new DemoExtend().show();
    }
}

class Demo {  //class修饰符 public final    变量和方法：public private protected  default
    public static final double PI = 3.141596; //static类变量共享，final常量

    void show() {
        System.out.println("东山大道 ......................");
    }

    Demo() {
    }

}

class DemoExtend extends Demo {
    @Override
    void show() {
        System.out.println("价格好几个 ......................");
    }
}
