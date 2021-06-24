package com.zqh.day0604;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestPool {
    public static void main(String[] args) throws SQLException {
        //先测试连接数据库 jdbc:mysql://localhost:3306/learn?useSSL=true&characterEncoding=utf8
        String url = "jdbc:mysql://localhost:3306/learn?useSSL=false";
        String user = "root";
        String password = "rootroot";
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(1);
        //jdbc连接池，数据库连接释放很耗时，用完回到连接池里！ url name password！
        //连接池基于代理模式，
        HikariDataSource ds = new HikariDataSource(config);
        try {
            ScheduledExecutorService ss = Executors.newScheduledThreadPool(1);
//        ss.schedule(new SqlTask("dada",ds.getConnection()),1,TimeUnit.SECONDS);
            ss.scheduleWithFixedDelay(new SqlTask("queryTask", ds)
                    , 0L, 3000L, TimeUnit.MILLISECONDS);//2次任务的时间周期！定时！
            //2s后执行线程，run代码执行完之后，间隔3s再一次执行！
        } catch (Exception e) {
            e.printStackTrace();
        }
//
////        try (Connection conn = ds.getConnection()) {
////            String sql = "select id,name,age from student  where id=? ";
////            PreparedStatement pstm = conn.prepareStatement(sql);
////            pstm.setInt(1, 1);
////            ResultSet rs = pstm.executeQuery();
////            while (rs.next()) {
////                Student s = new Student();
////                int index = 1;
////                s.setId(rs.getInt(index++));
////                s.setName(rs.getString(index++));
////                s.setAge(rs.getInt(index++));
////                System.out.println(s);
////            }
////        }
////        System.out.println(ds.getIdleTimeout());
////        try (Connection conn = DriverManager.getConnection(url, user, password)) {
////            String sql = "select id,name,age from student  where id=?";
////            PreparedStatement pstm = conn.prepareStatement(sql);
////            pstm.setInt(1, 1);
////            ResultSet rs = pstm.executeQuery();
////            while (rs.next()) {
////                Student s = new Student();
////                int index = 1;
////                s.setId(rs.getInt(index++));
////                s.setName(rs.getString(index++));
////                s.setAge(rs.getInt(index++));
////                System.out.println(s);
////            }
////        }
//        };
        //数据库操作,  鉴权+签名？
    }


}
