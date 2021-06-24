package com.zqh.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 利用多线程来实现聊天程序，收程序和发程序，所以需要多线程技术，一个线程控制收，一个线程控制发
 * 收发动作不一致，定义2个run方法，封装到不同类中
 */
public class ConnectDemo {
    public static void main(String[] args) throws SocketException {
        DatagramSocket sendSocket = new DatagramSocket();//随意占用发送端口
        Send send = new Send(sendSocket);
        new Thread(new Send(sendSocket)).start();

        DatagramSocket receSocket = new DatagramSocket(10002);//接收端绑定逻辑端口
        Rece rece = new Rece(receSocket);
        new Thread(new Rece(receSocket)).start();
    }
}


class Send implements Runnable {
    private DatagramSocket ds;

    public Send(DatagramSocket s) {
        this.ds = s;
    }

    //run方法里是子线程执行的程序！
    @Override
    public void run() {
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("发送端：请输入信息，回车发送！");
            while ((line = br.readLine()) != null) {
                if ("886".equalsIgnoreCase(line)) {
                    break;
                }
                byte[] buf = line.getBytes("gbk");
                DatagramPacket dgp =
                        new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.255"), 10002);
                ds.send(dgp);
                System.out.println("发送端：请输入信息，回车发送！");
            }

        } catch (Exception e) {
            throw new RuntimeException("发送端失败！"); //非检查异常！可以通过jvm编译
        }
    }
}

class Rece implements Runnable {
    private DatagramSocket ds;

    public Rece(DatagramSocket s) {
        this.ds = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
//                ds.bind(new InetSocketAddress("localhost", 10002));
                byte[] bytes = new byte[1024 * 64];
                DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length);
                ds.receive(dp);
                byte[] data = dp.getData();
                final String ip = dp.getAddress().getHostAddress();

                String msg = new String(data, 0, dp.getLength());
                System.out.println("服务端\t接收来自ip:" + ip + "数据：" + msg);
            }
        } catch (IOException e) {
            throw new RuntimeException("接收数据失败！");
        }
    }
}