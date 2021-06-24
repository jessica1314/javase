package com.zqh.day0601;

public class UserContext implements AutoCloseable {

    //这个类封装的静态属性保存了每个现成的独立副本！initialvalue初始化这个线程本地对象！
    static ThreadLocal<TestLocal.Person> ctx = ThreadLocal.withInitial(() -> new TestLocal.Person("tom", 1));

    //也可以通过手动构造关联实例
    public UserContext(TestLocal.Person person) {
        //构造的这个类时就把上下文绑定进来！
        ctx.set(person);
    }

    //其他地方可以调用此静态方法获取上下文信息！
    public static String currentUser() {
        if (ctx.get() != null) {
            return ctx.get().getName();
        }
        return "";
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(UserContext.currentUser());
    }
}
