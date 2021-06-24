package com.zqh.day06;

/**
 * 编译看父类方法，执行看子类方法
 * 特质成员函数？
 */
public class xx {
    public static void main(String[] args) {
        Fu fu = new Zi();
        fu.method();
        ((Zi) fu).method();
//        System.out.println(((Zi) fu).num);
//        System.out.println(fu.num); //执行属性时看父类
        fu.method1(); //zi mehtod1 运行时看右边对象的覆写方法！
        fu.method2();
//        fu.metod3(); //编译时只看左边的引用对象是否有method3方法。

    }
}

class Fu {
    int num = 0;

    void method1() {
        System.out.println("fu  method1");
    }

    void method2() {
        System.out.println("fu  method2");
    }

    static void method() {
        System.out.println("fu static method..........");
    }

}

class Zi extends Fu {
    int num = 2;
    int num2 = 10;

    void method1() {
        System.out.println("zi method1");
    }

    void method3() {
        System.out.println("zi method3");
    }

    static void method() {
        System.out.println("zi static method....");
    }
}

