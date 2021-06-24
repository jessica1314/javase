package com.zqh.day18;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PicDemo {
    public static void main(String[] args) {
    }
}

class PicClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("请选择一个jpg图片路径");
            return;
        }
        File file = new File(args[0]);
        if (!file.exists() &&!file.isFile()) {
            System.out.println("该文件有问题，要不不存在，要么不是文件");
            return;
        }
        if (!file.getName().endsWith(".jpg")) {
            System.out.println("图片格式错误，请重新选择");
            return;
        }
        if (file.length() > 1024 * 1024 * 5) {
            System.out.println("文件过大，请选择小于5k的图片！");
            return;
        }
        Socket client = new Socket("localhost", 10001);
        FileInputStream fis = new FileInputStream(file);
        final OutputStream os = client.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        client.shutdownOutput(); //告诉服服务器数据已写完
        final InputStream is = client.getInputStream();
        byte[] bufin = new byte[1024];
        final int num = is.read(bufin);
//        System.out.println(num);
        System.out.println(new String(bufin, 0, num));
//        client.close();
    }
}

class PicServer {

    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(10001);
        while (true) {
            Socket client = serverSocket.accept();
            new Thread(new PicThread(client)).start();
        }
//        serverSocket.close();
//        fileOutputStream.close();
    }
}

class PicThread implements Runnable {
    //    static int num = 1;
    private Socket client;

    public PicThread(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            int num = 1;
            final String ip = client.getInetAddress().getHostAddress();
            System.out.println(ip + "...............connected");
            InputStream is = null;
            is = client.getInputStream();
            FileOutputStream fileOutputStream = null;
            File file = new File(ip + "(" + num + ")" + "jpg");
            while (file.exists()) {
                file = new File(ip + "(" + ++num + ")" + "jpg");
            }
            fileOutputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while (((len = is.read(buf)) != -1)) {
                fileOutputStream.write(buf, 0, len);
            }
//        final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
//        printWriter.print("保存图片成功！".getBytes());
            OutputStream os = client.getOutputStream();
            os.write("上传成功".getBytes());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}