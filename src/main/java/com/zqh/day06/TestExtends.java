package com.zqh.day06;

/**
 * 测试员工类有三个属性：姓名 工号 工资
 * 和经理类 ：含有员工属性 多了个奖金属性
 * 类中提供属性访问方法
 */
public class TestExtends {
    public static void main(String[] args) {
        Eployee pro = new Pro("zhangsan11", "1001", 100.0);
        pro.work();
        System.out.println(pro.toString());
        Eployee manager = new Manager("wodi", "1002", 1000.00, 2);
        manager.work();
        System.out.println(manager.toString());


    }
}

abstract class Eployee {
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private String name;
    private String id;
    private double salary;

    //默认的修饰符 同包下可以用
    protected Eployee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    abstract void work();

    @Override
    public String toString() {
        return "Eployee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Pro extends Eployee {
    protected Pro(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    void work() {
        System.out.println("Pro is  working.........");
    }

    @Override
    public String toString() {
        return "Pro{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
}

class Manager extends Eployee {
    private int bonus;

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    protected Manager(String name, String id, double salary, int bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    void work() {
        System.out.println("manager is working ........");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", salary=" + getSalary() +
                ", bonus=" + bonus +
                '}';
    }
}