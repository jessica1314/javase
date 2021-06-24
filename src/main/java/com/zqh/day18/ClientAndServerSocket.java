package com.zqh.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class ClientAndServerSocket {
}

class TransClient {
    public static void main(String[] args) throws IOException {
        final Socket client = new Socket("localhost", 10000);
        final BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        String msg;
//        final BufferedWriter os =
//                new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
        final BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));
        while ((msg = br.readLine()) != null) {
            if ("over".equalsIgnoreCase(msg)) {
                break;
            }
            System.out.println("进入while.......");
            pw.println(msg);
//            pw.write(msg + System.lineSeparator());
            System.out.println("写入缓冲去了");
//            pw.flush(); //字符缓冲区一定别忘记了flush去清空缓冲区
            //等待服务端的返回！
            System.out.println("清空缓冲区了");
            final String s = is.readLine();
            System.out.println("server:" + s);
        }
        br.close();
        client.close();
    }

}


class TransServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(10000);
        final Socket client = server.accept();
        final String ip = client.getInetAddress().getHostAddress();
        System.out.println(ip + "...........connected");
        //获取客户端的输入流
        final BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //输出流
//        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        PrintWriter pw = new PrintWriter(client.getOutputStream(),true);
        String msg;
        System.out.println("等待接收客户信息。。。。。。。。。。");
        while ((msg = br.readLine()) != null) {   //截取传过来的回车符之前的信息！
            if ("over".equalsIgnoreCase(msg)) {
//                out.write("再见！" + System.lineSeparator());
//                client.close();
                break;
            }
//            pw.write(msg.toUpperCase() + System.lineSeparator());//一定手动加上回车符，否则对方接收不到信息！
            pw.println(msg.toUpperCase());
//            pw.flush();//清空缓冲区
        }
        client.close();
        server.close();
    }
}