package com.zqh.day11;


import java.util.Comparator;
import java.util.Objects;

/**
 * treeset集合，再添加元素进去的时候就利用对象的compareto方法判断大小，否则就报错！
 * 尽量多利用字符串本身的覆写的compareto方法进行比较！
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        System.out.println(Objects.hashCode(new P1("dada", 212)));
        System.out.println(Objects.hashCode(new P1("dadb", 211)));
        System.out.println(Objects.hash(new P1("dada", 212)));
//        TreeSet treeSet = new TreeSet(new MyCmp());
////        treeSet.add("cde");
////        treeSet.add("def");
////        treeSet.add("abc");
////        treeSet.add("bcd");
//        treeSet.add(new P1("zs", 10));
//        treeSet.add(new P1("zs", 20));
//        treeSet.add(new P1("abc", 20));
//        treeSet.add(new P1("abc", 10));
//        treeSet.add(new P1("zzz", 30));
//        sop(treeSet);
//        final Iterator it = treeSet.iterator();
//        while (it.hasNext()) {
//            P1 next = (P1) it.next();
//            sop("name=" + next.getName() + ";age=" + next.getAge());
//        }
    }

    static void sop(Object obj) {
        System.out.println(obj);
    }
}

class P1 {
    private String name;
    private int age;

    P1(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true; //同一个对象
        if (o == null || getClass() != o.getClass()) return false;
        P1 p1 = (P1) o;
        return getAge() == p1.getAge() && (name.equals(p1.name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getAge());
    }


//    @Override
//    public int compareTo(Object o) {
//        if (!(o instanceof P1)) {
//            throw new RuntimeException("类型不同，无法比较");
//        }
//        P1 o1 = (P1) o;
////        return getName().compareTo(o1.getName()) >= 0 ?
////                (getName().compareTo(o1.getName()) > 0 ? 1 : (getAge() > o1.getAge() ? 1 : (getAge() < o1.getAge() ? -1 : 0)))
////                : -1;
//        //先比主要的姓名属性，再比较次要的年龄属性
//        int res = 0;
//        int name_cmp = name.compareTo(o1.name);
//        int age_cmp = new Integer(age).compareTo(new Integer(o1.age));
//        if (name_cmp == 0) {
//            res = -age_cmp;
//        } else {
//            res = -name_cmp;
//        }
//        return res;
//    }
}

class MyCmp implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        P1 o11 = (P1) o1;
        P1 o22 = (P1) o2;
        int a = o11.getName().compareTo(o22.getName());
//        int b = new Integer(o11.getAge()).compareTo(new Integer(o22.getAge()));
        if (a == 0) {
            return new Integer(o11.getAge()).compareTo(new Integer(o22.getAge()));
        }
        return a;
    }
}