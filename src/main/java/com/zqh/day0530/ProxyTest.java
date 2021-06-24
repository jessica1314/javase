package com.zqh.day0530;

import java.lang.reflect.Proxy;

public class ProxyTest<T> {
    private T target;

    private T proxyInstance;

    ProxyTest(T target) {
        this.target = target;
        getProxy();
    }


    void getProxy() {
        proxyInstance = (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if (method.getName().equals("sale")) {
                        System.out.println("增强方法，打日志！！！");
                        method.invoke(target, args[0]);//执行实例自己的方法内容！
                    }
                    return null;
                });
    }

    //代理的是接口，但是通过实例获取接口！
    void sale(String name) {
        ((ProxyTest.Sale) (proxyInstance)).sale(name);
    }

    //代理接口？
    interface Sale {
        String sale(String name);  //需要增强的方法！
    }

    static class mai implements Sale {

        @Override
        public String sale(String name) {
            System.out.println("买东西！是：" + name);
            return "true";
        }
    }


}
