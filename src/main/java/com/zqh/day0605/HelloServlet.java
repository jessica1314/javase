package com.zqh.day0605;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/")
//http://localhost:8080/Hello/ 请求地址,  hello代表webapp的名字 /就是对应这个helloservlet类？
//tomcat服务器上可以部署多个webapps,如果都删除，默认的ROOT文件夹就对应的url的http://localhost:8080/
//启动tomcat，就是先启动jvm 然后调用tomcat的main方法，他加载我们的war包（自动解压成文件）
//然后创建HelloServlet实例运行，tomcat类似的web服务器也称为servlet容器！
//实例在容器中只有一份，多线程来调用，考虑安全问题  用到了localthread 保证处理完清掉参数
//自己无法new实例对象， tomcat自动创建唯一实例 使用多线程调用doget dopost方法
//src main java resources webapp（WEB-INFO/web.xml）
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应类型:
        System.out.println(req.getRequestURL());//不包含请求参数 协议 主机名 端口 资源路径 ，便于重定向 （请求转发）
        resp.setContentType("text/html");
        // 获取输出流:
        PrintWriter pw = resp.getWriter();
        // 写入响应:
        pw.write("<h1>Hello, world!</h1>");
        // 最后不要忘记flush强制输出:
        pw.flush(); //字符流 清空缓存区
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
