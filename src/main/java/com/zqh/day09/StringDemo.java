package com.zqh.day09;

public class StringDemo {
    public static void main(String[] args) {
        String str = "1212";
        System.out.println(str.hashCode());

        str += "ddadsad";
        System.out.println(str.hashCode());  //地址都变了，不是一个内存地址了

        String s1 = new String("dada");
        String s2 = "dada";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));


    }
}
