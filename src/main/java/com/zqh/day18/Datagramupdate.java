package com.zqh.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Datagramupdate {
    public static void main(String[] args) throws IOException {
        //通过udp发送一段数据出去
        final DatagramSocket ds =
                new DatagramSocket();
//        final DatagramSocket ds1 = new DatagramSocket(8889);//接收端必须在发送数据之前就开启！监听一个接收数据端口标识！d
        final Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入：任意语句，回车发送！");
        String count;
        while ((count = br.readLine()) != null) {
//            final String s = sc.nextLine();
            final byte[] d = count.getBytes("gbk");
            final DatagramPacket dp =
                    new DatagramPacket(d, d.length, new InetSocketAddress("localhost", 8889));
            //ip地址为：192.168.1.255：属于广播地址，会发送给这个网段中的所有子ip
            ds.send(dp);
            if ("over".equalsIgnoreCase(count)) {
                break;
            }
            System.out.println("请输入：任意语句，回车发送！");
        }
        ds.close();
    }
}