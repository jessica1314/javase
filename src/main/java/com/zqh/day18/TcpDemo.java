package com.zqh.day18;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * tcp传输
 * socket:客户端
 * serversocket：服务端,服务端监听端口，如果来了客户端连接，就通过客户端的对象来与客户端进行信！
 * 发现socket对象建立时，需要去连接指定主机，
 * 因为tcp面向连接，建立socket服务时，就要有服务端存在，
 * 并连接成功，形成通路，在该通道上进行数传输
 */
public class TcpDemo {
    public static void main(String[] args) throws IOException {
    }
}

class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端的socket服务，指定目的主机和端口,通道打通后，就能有输入和输出流
        final Socket client = new Socket("localhost", 10000);
        //为了发送数据，获取输出流
        OutputStream os = client.getOutputStream();
        os.write("tcp ge men lai le".getBytes("gbk"));
        final InputStream is = client.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = is.read(buf)) != -1) { //堵塞式方法等待服务端发送来的数据
            System.out.println(new String(buf, 0, len,"gbk"));
        }
//        client.close();
    }
}

class Server {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(10000);
        final Socket client = server.accept();//堵塞式方法
        final int port = client.getPort();
        final InetAddress inetAddress = client.getInetAddress();
        final String clientIpp = inetAddress.getHostAddress();
        System.out.println(clientIpp + ".............connected");

        final InputStream is = client.getInputStream();//拿取客户端的对象来获取输入流信息
        byte[] buf = new byte[1024];
        int len = 0;
//        while ((len = is.read(buf)) != -1) {
//            System.out.println("来自ip：" + clientIpp + "，port：" + port  + new String(buf, 0, len, "gbk"));
//        }
        len = is.read(buf);
        System.out.println("来自ip：" + clientIpp + "，port：" + port + new String(buf, 0, len, "gbk"));
        final OutputStream os = client.getOutputStream();
        os.write("我已收到你的信息，感谢连接！".getBytes("gbk"));

        client.close(); //服务器端接收到客户端连接后，然后就关闭通道！
        server.close();
    }
}
