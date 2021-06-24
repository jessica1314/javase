package com.zqh.day18;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端上传文件发送给服务端，保存在指定路径下！
 */
public class FileSocket {
    public static void main(String[] args) {

    }
}

class TextClient {
    public static void main(String[] args) throws IOException {
        final Socket client = new Socket("localhost", 10000);
        //读取文件
        final BufferedReader bufr = new BufferedReader(new FileReader("Ipdemo.txt"));
        //获取客户端的输出流；
        final OutputStream os = client.getOutputStream();
//        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os), true);
        String line = null;
        //处理基本类型！
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        long time = System.currentTimeMillis();
//        dos.writeLong(time);
//        System.out.println(time);
        while ((line = bufr.readLine()) != null) {
            pw.println(line);
        }
//        pw.println(time + "");
        client.shutdownOutput(); //关闭套接字流！发送-1；
        System.out.println("已发送标志");
        BufferedReader pw1 = new BufferedReader(new InputStreamReader(client.getInputStream()));
        final String s = pw1.readLine();
        System.out.println("服务端 ：" + s);
        bufr.close();
        client.close();
    }
}

class TextServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(10000);
        final Socket client = server.accept();
        System.out.println(client.getInetAddress().getHostAddress() + ".............connected");
        //获取客户端输入流
        final InputStream is = client.getInputStream();
        final BufferedReader br = new BufferedReader(new InputStreamReader(is));
        final PrintWriter pw = new PrintWriter(new FileWriter("Ipdemo3.txt"), true);
        String data = null;
        DataInputStream dis = new DataInputStream(is);
        long flag = dis.readLong(); //作为结束上传结束标志
        System.out.println(flag);
        while ((data = br.readLine()) != null) {
            System.out.println(data);
//            if (data.equals(flag + "")) {
//                System.out.println("true");
//                break;
//            }
            System.out.println("收到客户端信息" + data);
            pw.println(data);
//                pw.flush();
        }
        final PrintWriter pw1 = new PrintWriter(client.getOutputStream(), true);
        pw1.println("文件保存完毕！");
        client.close();
        server.close();
    }
}