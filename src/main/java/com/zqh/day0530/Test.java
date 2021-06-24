package com.zqh.day0530;

public class Test {
    public static void main(String[] args) {
        ProxyTest proxyTest = new ProxyTest(new ProxyTest.mai()); //构造代理对象！
        proxyTest.sale("吃饭");
    }
}
