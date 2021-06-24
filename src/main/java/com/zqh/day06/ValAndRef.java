package com.zqh.day06;

/**
 * 引用传递：实际参数的地址传给函数
 * 值传递 :复制一份数据给被调用函数
 */
public class ValAndRef {
    public static void main(String[] args) {
        String s = "A ";
        append(s);
        System.out.println(s);
        int a = 1; // a指向了堆中的1
        swap(a);
        System.out.println(a);

        System.out.println("======================");
        StringBuffer sb=new StringBuffer();
        sb.append("dasda1212");
        append(sb);
        System.out.println(sb);

        Employee tom = new Employee("tom", 100.0);
        Employee cat = new Employee("cat", 200.0);
        System.out.println(tom);
        System.out.println(cat);
        swap(tom, cat);
        System.out.println("===================");
        System.out.println(tom);
        System.out.println(cat);
    }

    private static void swap(Employee tom, Employee cat) {  //实参传过来的内存地址值，没有权利修改，只能去修改指向的内存地址内容
        /*
        传进来的变量，不可以修改本身的值，如果是引用对象，可以改变他对象属性和状态。
         */
    }

    static void swap(int a) {
        a = 2;  //a 指向了新的地址内容
        System.out.println(a);
    }

    static void append(String s) {
        s += "is a"; // +=字符串其实本质是重新new string("A is a")  //改变s的指向新的地址？
    }

    static void append(StringBuffer sb) {
        sb.append("dsadas");//提供了操作指定堆内存中的数据
        sb = new StringBuffer("dasda");  //指向了jvm堆中新的内存地址块
        System.out.println(sb);
    }
}


class Employee {
    private String name;
    private double salary;

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}