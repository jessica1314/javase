package com.zqh.day11;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 看hashset如何保存自定义对象！
 * 对象的内容一样就不存入啦
 * <p>
 * == ： 用于判断内存地址的， 看栈
 * equals:用于判断字符串的内容是否一样！ 看堆中的内容
 * <p>
 * arraylist删除元素是看equals，hashset是先看hashcode，相同再看equals
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(new Person("zhangsan", 10));
        hs.add(new Person("lisi", 10));
        hs.add(new Person("wangwu", 30));
        hs.add(new Person("zhangsan", 10));
//        sop(hs);
        sop("集合是否包含此对象：" + hs.contains(new Person("zhangsan", 10)));
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            Person next = (Person) it.next();
            if (next.equals(new Person("zhangsan", 10))) {
                it.remove(); //用迭代器引用来删除和遍历元素
            }
        }
        Iterator it1 = hs.iterator();
        while (it1.hasNext()) {
            Person next = (Person) it1.next();
            sop("name=" + next.getName() + ";age=" + next.getAge());
        }
//        for (Iterator it = hs.iterator(); it.hasNext(); ) {
//            Person next = (Person) it.next();
//            sop(next.getName() + ":" + next.getAge());
//        }
    }

    static void sop(Object obj) {
//        if (obj instanceof Collection) {
//            Iterator it = ((Collection) obj).iterator();
//            while (it.hasNext()) {
//                sop(it.next());
//            }
//        }
        System.out.println(obj);
    }
}

 class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object obj) {
        //指向同一对象！
//        if (this == obj) {
////            return true;
////        }
////        if (obj == null || getClass() != (obj.getClass()))
////            return false;
        if (!(obj instanceof Person))
            return false;
        Person obj1 = (Person) obj;
        return getName().equals(obj1.getName())
                && (age == obj1.age);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return this.age == person.age &&
//                Objects.equals(this.name, person.name);
//    }

    //先判断对象的地址，相同了再调用equals方法判断内容
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
}
