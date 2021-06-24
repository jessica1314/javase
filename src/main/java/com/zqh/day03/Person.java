package com.zqh.day03;

class Person1 {
    private String name;  //特有数据跟随对象  成员实例变量
    private int age;
    private static String country = "CN";  //共享的数据(类方法区/共享区)  类变量

    public Person1() {
    }

    public Person1(String name, int age) {
        this();
        System.out.println("3.我是构造方法。。。");
        this.name = name;  //代表当前对象引用？ this代表它所在函数所属的对象的引用？  哪个对象在调用this所在的函数，this就代表哪个对象？
        this.age = age;
    }


    public Person1(String name) {
        this(name, 0); //int default 0

    }

    public Person1(int age) {
        this(null, age);  //构造函数调用用this（实参列表）  必须首行
    }


    {
        System.out.println("2.我是对象共享初始化块。。。。。");
    }

    static {
        System.out.println("1.我是静态类初始化块。。。。。"); //在执行这个类里的主函数时，肯定先执行类方法块
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void speak() {
        System.out.println("name:" + name + ",age:" + age + ",国家：" + country);    //对象的属性 隐含了当前的this对象？
    }

    /**
     * @param p 传入的比较的人
     * @return
     */
    public boolean compare(Person1 p) {
        return this.age == p.getAge();  //this是不是表示调用该函数的对象？

    }

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        Person1 p1 = new Person1(20);
        p1.speak();
        p1.setName("da");
        p1.speak();
        Person1 p2 = new Person1(25);
        p2.speak();
        System.out.println(p1.compare(p2));  //this代表p1对象

        Person1 lisi = new Person1("lisi");  //this --> lisi
        lisi.speak();
        System.out.println("========================");
        Person1 zhangsan = new Person1("zhangsan");  //this --> zhangsan
        zhangsan.speak();

        System.out.println(Person1.country);  //static 属于类的属性
    }
}

class MainTest {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        Person1.main(arr);
    }
}