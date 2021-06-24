package com.zqh.day15;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(".\\FileWriterDemo.txt");
        fileWriter.write("这是一个测试!");
        fileWriter.flush();
        fileWriter.write("这是一个测试!");
        fileWriter.flush();
        fileWriter.close();
        fileWriter.close();
    }
}
