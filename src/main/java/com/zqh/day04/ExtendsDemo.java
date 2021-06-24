package com.zqh.day04;


/**
 * 测试继承的特性
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("=======================");
        Student s2 = new Student('女');
      /*  student.show();
        student.setAge(25);
        System.out.println(student.toString());*/
    }
}

/**
 * 将学生和工人的共性提取出来，放在一个类中，这个类成为父类？
 * 提高代码复用率，类之间产生关系，有了关系才有多态的特性！
 * 类之间有所属关系，如is-a,才能继承
 * 只支持单继承,支持多层继承，继承体系，
 * 使用体系先看体系中的父类描述，通过了解共性功能，基本可以使用！
 * 在具体使用时要使用最子类的对象！原因：父类可能是抽象的不能实例；
 * 子类对象可用的方法多，包含基本和特有的
 * 查阅父类功能，创建子类对象使用功能
 * super:代表父类对象的引用
 * 子类继承父类的属性，
 * 子类初始化时，先构造父类再构造父类，因为继承后会用到父类的属性。
 */
class Student extends Person {

    private char sex = '男';

    Student() {
//        super();//隐含了这行代码！调用父类的空构造函数
        this.name = "dasda";
        System.out.println("父类静态属性：" + Person.country);
        System.out.println("我是子类的构造方法。。。。。。。。。。。");
    }

    Student(char sex) {
        this.sex = sex;
        System.out.println("我是带参构造方法。。。。。。。。。。。。,sex="+sex);
    }

    void show() {
        System.out.println(this.name);
    }

    static {
        System.out.println("2.我是子类的静态代码块");
    }

    {
        System.out.println("我是子类非静态代码块");
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Student{ name:'" + this.getName() + "',age:" + this.getAge() + ",sex:'" + this.sex + "'}";
    }
}

class Worker extends Person {

}

class Person {
    static String country = "CN";
    String name = "person";
    int age = 2;

      Person() {
        System.out.println("我是父类构造方法。。。。。");
    }

    static {
        System.out.println("1.我是父类静态代码块。。。。");
    }

    {
        System.out.println("我是父类非静态代码块。。。。。。。。。。。");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


