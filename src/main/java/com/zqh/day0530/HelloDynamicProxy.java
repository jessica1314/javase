package com.zqh.day0530;

import java.lang.reflect.InvocationHandler;

public class HelloDynamicProxy implements Hello {
    //需要有个hanlder对象
    private static InvocationHandler handler;

    HelloDynamicProxy(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void sayMorning(String name) throws Throwable {
        handler.invoke(this,
                Hello.class.getMethod("sayMorning", String.class),
                new Object[]{name}
        );
    }

}
