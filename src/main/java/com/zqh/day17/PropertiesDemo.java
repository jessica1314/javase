package com.zqh.day17;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        //注册次数的统计，内存中计算完保存在配置文件中
        Properties prop = new Properties();
        File file = new File("count.properties");
        if (!file.exists())
            file.createNewFile();
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        int count = 0;
        String value = prop.getProperty("time");
        if (value != null) {
            count = Integer.parseInt(value);
            if (count >= 5) {
                System.out.println("你好，使用次数已到！");
                return;
            }
        }
        count++;
        prop.setProperty("time", String.valueOf(count));
        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, null);
        fos.close();
        fis.close();
    }
}
