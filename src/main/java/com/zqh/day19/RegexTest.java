package com.zqh.day19;

import java.io.*;
import java.net.URL;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) throws IOException {
        getHtml();
    }

    /**
     * 获取指定文档中的邮件地址！ pattern mathcer
     */
    public static void getMail() throws IOException {
        BufferedReader bufr = new BufferedReader(new FileReader("mail.txt"));
        String line = null;
        String regex = "\\w+@\\w+(\\.\\w+)+";
        Pattern pattern = Pattern.compile(regex);
        TreeSet<String> set = new TreeSet<>();
        while ((line = bufr.readLine()) != null) {
            final Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                final String group = matcher.group();
                set.add(group);
//                System.out.println(group);
            }
//            System.out.println(line);
        }
        System.out.println(set.size()+","+set);
    }
    /**
     * 获取指定文档中的邮件地址！ pattern mathcer
     */
    public static void getHtml() throws IOException {
        final URL url = new URL("http://localhost:8080/index.html");

        final InputStream inputStream = url.openConnection().getInputStream();
//        final InputStream inputStream = url.openConnection().getco();

        BufferedReader bufr = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        String regex = "\\w+@\\w+(\\.\\w+)+";
        Pattern pattern = Pattern.compile(regex);
        TreeSet<String> set = new TreeSet<>();
        while ((line = bufr.readLine()) != null) {
            final Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                final String group = matcher.group();
                set.add(group);
//                System.out.println(group);
            }
//            System.out.println(line);
        }
        System.out.println(set.size()+","+set);
    }
}
