package com.zqh.day18;

import java.io.IOException;
import java.net.*;

public class Test01 {
    public static void main(String[] args) throws IOException {
        //通过udp发送一段数据出去
        final DatagramSocket ds =
                new DatagramSocket(8888);
        final DatagramSocket ds1 = new DatagramSocket(8889);//接收端必须在发送数据之前就开启！监听一个接收数据端口标识！
        final byte[] d = "你好".getBytes("gbk");
        final DatagramPacket dp =
                new DatagramPacket(d, d.length, new InetSocketAddress("localhost", 8889));
        ds.send(dp);
        ds.close();

        final DatagramPacket d2 = new DatagramPacket(new byte[1024], 1024);
        ds1.receive(d2);
//        final byte[] data = d2.getData();
        final String remote = d2.getAddress().getHostAddress();
//        System.out.println(remote);
        System.out.println("from: " + d2.getAddress().getHostAddress() + ",port:" + d2.getPort() +"的消息："+ new String(d2.getData(), 0, d2.getLength(), "gbk"));
        ds1.close();
    }

    private static void method_01() throws UnknownHostException {
        //        final InetAddress i = InetAddress.getLocalHost();
//        System.out.println(i);//JESSICA/172.24.16.1
//        System.out.println(i.getHostName() + "," + i.getHostAddress());
        InetAddress[] inetAddresses = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress a : inetAddresses) {
            System.out.println(a);
        }
//        System.out.println(InetAddress.getByName("www.baidu.com"));//主机名？
    }
}
