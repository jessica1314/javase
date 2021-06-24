package com.zqh.day0603;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethodReference {
    public static void main(String[] args) {

        List<String> ll = Arrays.asList("tom", "harry", "lilith");
        //想要引用person类的构造方法变成一个个对象
        //此处的map方法参数是函数接口内部的抽象方法是-》R apply(T t);  一个输入参数 一个返回参数！
        //pp::new  构造方法就是输入一个参数  返回一个隐含的this实例类！
        List<Pp> l = ll.stream().map(Pp::new).collect(Collectors.toList());
        System.out.println(l);
        System.out.println(Arrays.asList(1,2,3,4));
        final String[] ints = {"1", "3", "4", "5"};
        System.out.println(Arrays.asList(ints));
        //方法签名相同指的是：参数类型和数量以及返回类型相同，不考虑方法名；静态 实例 构造都适用


    }


    class Person {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Person(String name) {
            this.name = name;
        }
    }

}

