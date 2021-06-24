package com.zqh.day0530;

import java.util.Arrays;

public class TestFun {
    public static void main(String[] args) {
        //标注有@functioninterface注解的都是函数接口
        //内部至少有一个抽象方法，静态方法和继承来的除外
        //使用lambda表达式，就不必写函数接口的实现类，简化代码
        //Arrays.sort(array,(s1,s2)->{s1.compareTo(s2)})
        //也可以使用方法引用(不肯定是静态方法 对吧 system.out::println)
        //方法的签名和接口恰好一致，直接传入方法引用
        //也可以直接用String的compareTo实例方法！隐含传入了this
        //虽然参数不一致！
        String[] arr = {"apple", "pea", "banana"};
        //静态方法
//        Arrays.sort(arr,TestFun::compare);
        //引用实例方法
        Arrays.sort(arr,String::compareTo);
        System.out.println(String.join(",",arr));
        //还可以引用构造方法

    }

    private static  int compare(String t, String t1) {
        return -t.compareTo(t1);
    }
}
