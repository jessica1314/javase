package com.zqh.day0601;

public class TestLocal {
    //各个线程的ThreadLocal实例互不干扰的，独立的存储空间，
    //在普通方法内使用该对象都是同一实例！

    static ThreadLocal<Person> threadLocalUser = new ThreadLocal<>();

    public static void main(String[] args) {
        //测试threadlocal对象，用来保存一个线程中的需要的对象信息
        Person p = new Person("tome",10);
        p.setAge(10);
        p.setName("tom");
        //把user实例关联到ThreadLocal中
        threadLocalUser.set(p); //保存上下文信息到此变量中
        //这里可以被所有方法随时调用该User实例
        //处理完数据以后可以调用remove方法
        threadLocalUser.remove();
        //一定使用完记得清除，web工程响应请求，从线程池中拿出一个线程来去执行任务，完成任务后放回到线程池中，如果不remove掉这次信息，
        //下次这个线程会带着上一次的状态
        //实现autoclose接口配合try（resource）｛。。。｝结构去让编译器自动为我们关闭资源
        //例如：一个保存了当前用户名的threadlocal可以封装为usercontext对象：


    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


}
