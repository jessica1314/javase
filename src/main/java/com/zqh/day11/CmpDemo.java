package com.zqh.day11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 按照存入的字符串长度来排序，
 */
public class CmpDemo {
    public static void main(String[] args) {
        // (x<y)?-1:((x=y)?0:1)
        //(x < y) ? -1 : ((x == y) ? 0 : 1)
        // (Comparator<String>(o1,o2))  ,匿名函数或者lamda表达式，找父类接口的函数名和抽象方法！
        TreeSet treeSet = new TreeSet((Comparator<String>) (o1, o2) -> {
            String o11 = o1;
            String o21 = o2;
            int a = Integer.compare(o11.length(), o21.length());
            if (a == 0) {
                return o11.compareTo(o21);
            }
            return a;
        });
        treeSet.add("dbc");
        treeSet.add("bac");
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("abcdef");
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            sop(it.next());
        }
    }

    private static void sop(Object next) {
        System.out.println(next);
    }


}

//class Cmp implements Comparator {
//    @Override
//    public int compare(Object o1, Object o2) {
//        String o11 = (String) o1;
//        String o22 = (String) o2;
//
//        int i = new Integer(o11.length()).compareTo(new Integer(o22.length()));
//        if (i == 0) {
//            return o11.compareTo(o22);
//        }
//        return i;
//    }
//}
