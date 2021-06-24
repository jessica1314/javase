package com.zqh.day06;

/**
 * 多态：事物的不同体现形态
 * 人分为男人和女人
 * 动物分为猫和狗  具有所属关系
 * 所以小类型自动向上转化为大类型 比如基本类型: byte向上转型为int类型；
 * 引用类型也可以转型？  Animal cat = new Cat(); 向上自动转型为父类 ，如果调用Cat特有属性，就强制向下转型
 * 判断类型：编译看左边，运行看右边
 * 1.多态的体现  上层可以调用传入父类引用的方法
 * 2.多态的出现提高了程序的扩展性？ 前提必须类与类之间关系：要么继承 要么实现；存在覆盖方法
 * 3.多态的弊端：只能使用父类引用访问父类的成员
 * 4.多态自始至终都是子类的对象在变化
 */
public class  DuoTaiDemo {

    public static void main(String[] args) {
        Animal dog = new Dog("金毛", '公'); //父类的引用指向了子类的对象！ 既是动物也是狗
        function(dog);
        Animal cat = new Cat("加菲猫", '母'); //类型提升向上转型？
        function(cat);
    }

    //抽取了子类的公有方法，
    public static void function(Animal animal) {
        if (animal instanceof Cat) {  //instanceof 类型有限？判断类型
            ((Cat) animal).catchMouse();
        }
        if (animal instanceof Dog) {
         ((Dog) animal).kenBone();
        }
    }
}

abstract class Animal {
    private String name;
    private char sex;

    public Animal(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

    //不确定的功能，动物特有的方法
    abstract void eat();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}

class Dog extends Animal {
    public Dog(String name, char sex) {
        super(name, sex);
    }

    @Override
    void eat() {
        System.out.println("dog吃肉。。。。。。。。。。。。");
    }

    public void kenBone() {
        System.out.println("dog吃骨头呢。。。。。");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("cat吃。。。。。");
    }

    public Cat(String name, char sex) {
        super(name, sex);
    }


    public void catchMouse() {
        System.out.println("猫去抓耗子。。。。。。。。。。。。。");
    }


}