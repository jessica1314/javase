package com.zqh.day0530;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestCollection {
    //集合：一个对象内部可以持有若干个其他java对象，并对外提供访问接口
    //数组 也是一种集合，长度确定 按索引顺序查找
    //可变的链式表 无重复元素的集合
    //迭代器 iterator 实现遍历元素
    //collection接口：分为 list set  另外还有map接口
    //Enumeration<E> 被Iterator<E> 替换了
    //List  ArrayList和LinkedList
    //遍历使用Iterator对象 List的方法
    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        l.add(2);
//        l.add(3);
//        l.add(null);
//        //最高效的遍历方式
//        Iterator<Integer> it = l.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//        //比较好 不会丢失类型信息！ list 转 array
//        Integer[] integers = l.toArray(new Integer[l.size()]);
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }
//        //array 转 list
//        List<Integer> integers1 = Arrays.asList(integers);
//        for (Integer integer : integers1) {
//            System.out.println(integer);
//        }
        // 构造从start到end的序列：
        // 构造从start到end的序列：
//        final int start = 10;
//        final int end = 20;
//        List<Integer> list = new ArrayList<>();
//        for (int i = start; i <= end; i++) {
//            list.add(i);
//        }
//        // 洗牌算法shuffle可以随机交换List中的元素位置:
//        Collections.shuffle(list);
//        // 随机删除List中的一个元素:
//        int removed = list.remove((int) (Math.random() * list.size()));
//        int found = findMissingNumber(start, end, list);
//        System.out.println(list.toString());
//        System.out.println("missing number: " + found);
//        System.out.println(removed == found ? "测试成功" : "测试失败");
        final List<String> list =
                Arrays.asList("1", "2", "4", "6");
        //通过equals比较String内容的
        //集合内放入自身定义的类的话，需要重写equals方法
//        System.out.println(list.contains(new String("2")));
//        System.out.println(
//                list.indexOf(new String("2"))
//        );

//        List<Person> pp = new ArrayList<>();
//        pp.add(new Person("tom", "2",1));
//        pp.add(new Person("tom1", "22",2));
//        pp.add(new Person("tom12", "22",2));
//        System.out.println(pp.contains(new Person("tom", "2",1)));
//        System.out.println(pp.indexOf(new Person("tom", "2",1)));
        //hashmap 中存放了key索引的数组，当key相同时就链式存放
        //默认长度16，每次扩容一倍，然后重新hash所有的key值，性能问题，初始化长度也是2的最小n次幂
        //存在相同的key的hashcode一样就会存放在List<Entry<k,v>>;存放在不同的键值对，冲突越大这个list越长，性能也慢
        //用作hashmap的key对象必须重写hashcode和equals方法，都用上所有的field
        //通过Objects.hashcode()实现 Object.equals(Object a,Object b)
        //hashmap的key其实无序的，sortedMap接口支持有序存放，实现类treeMap，但是key必须实现comparable接口或者初始化传入一个comparator匿名类


    }

    //异或方法，相同元素异或为0；不同为1;
    private static int findMissingNumber(int start, int end, List<Integer> list) {
//        int sum=(start+end)*(end-start+1)/2;
//        for (Integer con : list) {
//            sum-=con;
//        }
//        System.out.println(sum);
//        if (sum > 0) {
//            return sum;
//        } else {
//            return 0;
//        }
        return (start + end) * (end - start + 1) / 2 - list.stream().reduce(0, Integer::sum);
    }

    static class Person {
        String firstName;
        String lastName;
        int age;

        @Override
        //这里的属性必须是包含在equals方法里的所有！
        public int hashCode() {
            return Objects.hash(firstName, lastName, age);
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }


        //如果这些元素不需要比较，也就不需要这个方法啦
        @Override
        public boolean equals(Object obj) {

            if (obj instanceof Person) {
                Person p = (Person) obj;
                return Objects.equals(getFirstName(), p.getFirstName()) && Objects.equals(getLastName(), p.getLastName()) && age == p.getAge();
            }
            return false;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public void setFirstName(String name) {
            this.firstName = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
