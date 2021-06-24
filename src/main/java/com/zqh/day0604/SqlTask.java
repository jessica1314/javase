package com.zqh.day0604;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SqlTask implements Runnable {
    private final DataSource dataSource;
    String taskName;
    //这个线程就用这一个conn实例，修改为使用多个之一？
    static Integer num = 0;

    @Override
    public void run() {
        String sql = "select id,name,age from student  where id=? ";
        PreparedStatement pstm = null;
        Connection connection = null;
        ResultSet rs;
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("load....");
            connection = dataSource.getConnection();
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, 1);
            rs = pstm.executeQuery();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (rs.next()) {
                System.out.println(connection);
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setAge(rs.getInt(3));
                String time = formatter.format(LocalDateTime.now());
                System.out.println("第" + num++ + "次查询结果：" + s + "\t时间:" + time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (pstm != null)
                    pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public SqlTask(String queryTask, DataSource ds) {
        taskName = queryTask;
        dataSource = ds;
    }

}
