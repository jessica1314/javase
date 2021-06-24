package com.zqh.day0605;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TestWeb {
    public static void main(String[] args) throws IOException {
        //javaEE  web开发 java platform enterprise  edition 企业平台
        //基于javaEE 服服务器接口和库  jdk（jre）jre：jvm
        //基于服务器组件 api标准  通用架构
        //核心组件 基于servlet标准的web服务， 程序都是基于servlet api 运行在web服务内
        //app（servlet实例） servlet api  web server （tomcat） jse（jvm）
        //ejb spring  jaas(认证和授权) jca jms【消息服务】jta【分布式事务】jax-ws[构建基于xml的web服务]
        //主流基于spring 轻量级javaee开发架构 ，servlet和jms以及开源组件
        //物理 链路 网络(ip) 传输（tcp） 会话 表现 应用
        //bs结构  browser/server
        //
        //其实http server本质就是类似tcp服务器
        //http协议是 请求和响应协议，1.1 在一个tcp连接可以进行多次的请求和响应
        //2.0 支持同时发送多次请求有标识，服务器按不同顺序返回响应，提高速度，不用等待回应 继续发送请求
        //3.0 抛弃http协议，udp  处于尝试阶段
        //web开发 服务器端的web应用程序
        //基于多线程的tcp服务， 考虑处理： 请求 头 复用tcp  复用线程 io异常
        //基于javaee开发平台，处理tcp连接，解析协议交给web服务器去做，把程序跑在web服务器上即可
        //javaee 提供了servlet api 编写处理http请求  web服务器实现了servlet api接口 实现底层功能
        ServerSocket ss = new ServerSocket(8080); // 监听指定端口
        //请求来了 Web服务器  servlet api  app
        //达成的war包 需要放入web服务器 才能处理请求
        //支持servlet服务器： tomcat jetty  glassfish weblogic websphere

        System.out.println("server is running...");
        for (; ; ) {
            Socket sock = ss.accept();
            System.out.println("connected from " + sock.getRemoteSocketAddress());
            Thread t = new Handler(sock);
            t.start();
        }
    }

    private static class Handler extends Thread {
        private Socket sock;

        public Handler(Socket sock) {
            this.sock = sock;
        }

        @Override
        public void run() {
            try (InputStream input = sock.getInputStream()) {
                try (OutputStream output = sock.getOutputStream()) {
                    handle(input, output);
                }
            } catch (Exception e) {
                try {
                    sock.close();
                } catch (IOException ioe) {
                }
                //客户端释放连接
                System.out.println("client disconnected.");
            }
        }

        private void handle(InputStream input, OutputStream output) throws IOException {
            System.out.println("Process new http request...");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
            // 读取HTTP请求:
            boolean requestOk = false;
            String first = reader.readLine();
            if (first.startsWith("GET / HTTP/1.")) {
                requestOk = true;
            }
            for (; ; ) {
                String header = reader.readLine();
                if (header.isEmpty()) { // 读取到空行时, HTTP Header读取完毕
                    break;
                }
                System.out.println(header);
            }
            System.out.println(requestOk ? "Response OK" : "Response Error");
            if (!requestOk) {
                // 发送错误响应:
                writer.write("HTTP/1.0 404 Not Found\r\n");
                writer.write("Content-Length: 0\r\n");
                writer.write("\r\n");
                writer.flush();
            } else {
                // 发送成功响应:
                String data = "<html><body><h1>Hello, world!</h1></body></html>";
                int length = data.getBytes(StandardCharsets.UTF_8).length;
                writer.write("HTTP/1.0 200 OK\r\n");
                writer.write("Connection: close\r\n");
                writer.write("Content-Type: text/html\r\n");
                writer.write("Content-Length: " + length + "\r\n");
                writer.write("\r\n"); // 空行标识Header和Body 两个\r\n的分隔
                writer.write(data);
                writer.flush();

            }
        }
    }
}
