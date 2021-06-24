package com.zqh.day0530;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TestPro {
    public static void main(String[] args) throws IOException {
        String path = "1.properties";
        Properties prop = new Properties();
//        prop.load(new FileInputStream(path));
//        prop.load(TestPro.class.getResourceAsStream("/2.properties"));
        prop.load(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));

    }
}
