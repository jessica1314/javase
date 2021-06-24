package com.zqh.day18;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LoginDemo {
}

class LoginClient {
    public static void main(String[] args) throws IOException {
        final Socket client = new Socket("localhost", 10001);
        final Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
        final BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //只输入3次
        for (int i = 0; i < 3; i++) {
            final String s = sc.nextLine();
            if (s == null) {
                break;
            }
            pw.println(s);
            final String info = br.readLine();
            System.out.println("info:" + info);
            if (info.contains("欢迎")) {
                break;
            }
        }
        br.close();
        client.close();

    }
}

class LoginServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(10001);
        while (true) {
            Socket s = server.accept();
            new Thread(new UserThread(s)).start();
        }

    }
}

class UserThread implements Runnable {
    private Socket s;

    public UserThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "...................connected");
        try {
            for (int i = 0; i < 3; i++) {
                final BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                final String name = br.readLine();
                if (name == null) {
                    System.out.println("输入用户民位null");
                    break;
                }
                final BufferedReader bufr = new BufferedReader(new FileReader("user.txt"));
                final PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                String line = null;
                boolean flag = false;
                while ((line = bufr.readLine()) != null) {
                    if (!line.equals(name)) {
                        continue;
                    }
                    flag = true;
                    break;
                }
                if (flag) {
                    System.out.println(name + "已登录");
                    pw.println(name + ",欢迎光临");
                    break;
                } else {
                    System.out.println(name + "尝试登录");
                    pw.println(name + ",用户民不存在");
                }
            }
            System.out.println("跳出循环");
            s.close();
        } catch (Exception e) {
            throw new RuntimeException(ip + "登录失败");
        }

    }
}