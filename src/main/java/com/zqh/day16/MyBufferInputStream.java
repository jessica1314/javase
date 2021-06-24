package com.zqh.day16;

import java.io.IOException;
import java.io.InputStream;

public class MyBufferInputStream {
    public static void main(String[] args) throws IOException {
//        String base = "C:\\Users\\Administrator\\Desktop\\";
//        String imageUrl = base + "cat.jpg";
//        MyBufferInputStream mbi = new MyBufferInputStream(new FileInputStream(imageUrl));
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(base + "\\cat1.jpg"));
//        int ch = 0;
//        while ((ch = mbi.myRead()) != -1) {
//            bos.write(ch);//字节流不需要清除缓冲区
//        }
//        mbi.myClose();
//        bos.close(); //缓存的数据？
    }

    private InputStream in;
    private byte[] buf = new byte[1024];
    private int pos = 0, count = 0;

    public MyBufferInputStream(InputStream in) {
        this.in = in;
    }

    //一次读一个字节，从缓冲区（字节数组）中读
    public int myRead() throws IOException {
        //通过in对象读取硬盘数据，并存储到buf中
        if (count == 0) {
            count = in.read(buf);
            pos = 0;
            if (count == -1)
                return -1;
        }
        byte b = buf[pos];
        pos++;
        count--;
        //防止byte自动转型为int，高位全补1
        return b & 0xff;  //取byte的有效8位，有效数据11111-1111：代表的是255，不是-1，
    }

    private int read01() throws IOException {
        if (count == 0) {
            count = in.read(buf);
            if (count < 0) {
                return -1;
            }
            pos = 0;
            byte b = buf[pos];
            pos++;
            count--;
            return b & 0xff; //让其int类型的前3个字节补充0
        } else if (count > 0) {
            byte b = buf[pos];
            pos++;
            count--;
            return b & 0xff;
        }
        return -1;
    }

    public void myClose() throws IOException {
        in.close();
    }
}
