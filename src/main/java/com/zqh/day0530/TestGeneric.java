package com.zqh.day0530;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGeneric {
    //泛型：目的 模板类型 方便编译 发现错误 也不用考虑类型转换 安全
    public static void main(String[] args) {
        List<String> ll = new ArrayList<>();
//        List<Object> l1 = new ArrayList<String>(); 不可以的
//        List<Object>  和 List<String> 么有任何继承关系
        // 这里的泛型不可以变化？
//        final Pair<String> stringPair = new Pair<>("1", "2");
        final Pair1<String, Integer> stringIntegerPair1 = new Pair1<>("1", 2);
        String[] arr = asArray("one", "two", "three");
        System.out.println(Arrays.toString(arr));
        // ClassCastException:
        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));
    }

    int sumOfSum(List<? extends Integer> list) {
        //用extends通配符表示可以读，可读的，但不适用于写时
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        for (Integer number : list) {
            sum += number;
        }
        return sum;
    }

    //这个方法可以接受number的子类？
    static int add(Pair<? extends Number> pair) {
        return pair.getFirst().intValue() + pair.getEnd().intValue();
    }

    static class Pair<T extends Number> {
        private T first;
        private T end;

        Pair(T first, T end) {
            this.first = first;
            this.end = end;
        }

        public T getFirst() {
            return first;
        }

        public T getEnd() {
            return end;
        }

    }

    // 静态泛型方法应该使用其他类型区分:  使用k
    public static <K extends Number> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }

    static class Pair1<T, K> {
        private T first;
        private K end;

        Pair1(T first, K end) {
            this.first = first;
            this.end = end;
        }

        public T getFirst() {
            return first;
        }

        public K getEnd() {
            return end;
        }
    }

    static <T> T[] asArray(T... objs) {
        return objs;
    }
    static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2);
    }

}
