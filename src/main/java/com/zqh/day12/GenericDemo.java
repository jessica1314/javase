package com.zqh.day12;

import java.util.*;

/**
 * 测试泛型类和泛型方法
 */
public class GenericDemo {
    public static void main(String[] args) {
        TreeSet<Student> al = new TreeSet(new MyCmp1());
        al.add(new Student("001"));
        al.add(new Student("002"));
        al.add(new Student("003"));
        final Iterator<Student> iterator = al.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("========================");
        TreeSet<Worker> a2 = new TreeSet(new MyCmp1());
        a2.add(new Worker("w01"));
        a2.add(new Worker("w02"));
        a2.add(new Worker("w03"));
        final Iterator<Worker> iterator1 = a2.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    }

    private static void method02() {
        ArrayList<String> al = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        al.add("dasdas");
        al.add("weqeqw");
        al.add("vbd");
        al.add("nvbn");
        printCollect(al);
        a2.add(1);
        a2.add(2);
        a2.add(3);
        a2.add(4);
        printCollect(a2);
        System.out.println("==========================");
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("01"));
        arrayList.add(new Student("02"));
        printPerson(arrayList);
    }

    static <T> void printCollect(ArrayList<T> al) {  //此处的<T>表示要处理的对象具体泛型，？代表不明确类型
        Iterator<T> it = al.iterator();
        while (it.hasNext()) {
            T next = it.next(); //此处可以接受此T类型对象元素
            System.out.println(next);
        }
    }

    static void printPerson(ArrayList<? extends Person> al) {  //? extends Person，泛型限定符，限定传入的都是person的子类
        Iterator<? extends Person> it = al.iterator();
        while (it.hasNext()) {
            Person next = it.next(); //此处可以接受此T类型对象元素
            System.out.println(next); //因为是泛型所以使用的方法是通用的，运行看右边，编译看左边！
        }
    }

    private static void method01() {
        final Util<String> util = new Util<>();
        util.add("122122122122122122122");
        util.add("dadda");
        util.add("weqeq");
        util.add("kmkm");
        List<String> content = util.getContent();
        final Iterator<String> it = content.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class Util<T> {
    private T name;
    private ArrayList<T> list = new ArrayList<>();

    List<T> getContent() {
        return list;
    }

    //静态方法不可以访问费静态元素，如果定义泛型在方法上的返回值前面？ (前面的<w>：是指示该方法操作的数据泛型 后面的W：是返回值类型！)
    static <W> W print(W w) {
        System.out.println(w);
        return w;
    }

    void add(T a) {
        list.add(a);
    }
}

class MyCmp1 implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class MyStuCmp implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class MyWorkCmp implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return o2.getName().compareTo(o1.getName());
    }

}

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {

    Student(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Student{name='" + getName() + "'}";
    }
}

class Worker extends Person {
    Worker(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Worker{name='" + getName() + "'}";
    }
}