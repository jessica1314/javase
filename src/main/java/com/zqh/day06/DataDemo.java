package com.zqh.day06;

/**
 * 数据库操作
 * 数据信息？
 * 1.连接数据库 JDBC c3p0 hibernate框架
 * 2.操作数据库
 * 增删改查 CRUD create read uodate delete
 * 3.关闭数据库
 */
public class DataDemo {
    public static void main(String[] args) {

    }
}

class UserInfoByJDBC {
    public void add(User user) {
        //连接数据库 使用sql添加数据 关闭连接
    }

    public void delete(User user) {

    }
}

class DBOperate {
    public static void main(String[] args) {
        UserInfoByJDBC ui = new UserInfoByJDBC();
        //userinfobyhibernate了对象获取数据， 这里需要调用父类的接口
        ui.add(new User("zs", 10));

    }
}
