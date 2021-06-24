package com.zqh.day18;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Datagramrece {
    public static void main(String[] args) throws IOException {
        //接收端先开启，监听制定数据端口！
        final DatagramSocket ds1 = new DatagramSocket(8889);//接收端必须在发送数据之前就开启！监听一个接收数据端口标识！
        while (true) {
            final DatagramPacket d2 = new DatagramPacket(new byte[1024], 1024);
            ds1.receive(d2);//堵塞式
            final byte[] data = d2.getData();
            final String data1 = new String(data, "gbk");

            final String remote = d2.getAddress().getHostAddress();
//        System.out.println(remote);
            System.out.println("from: " + d2.getAddress().getHostAddress() + ",port:" + d2.getPort() + "的消息：" + data1);
            System.out.println(d2.getLength());
            if ("over".equalsIgnoreCase(data1.trim())) {
                break;
            }
        }
        ds1.close();
    }
}
