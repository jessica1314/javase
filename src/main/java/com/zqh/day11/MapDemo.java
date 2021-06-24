package com.zqh.day11;

import java.util.*;

/**
 * 测试map对象
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("01", "zs1");
        System.out.println(map.put("01", "null"));
        System.out.println(map.put("02", "zs2"));
        map.put("03", "zs3");
        System.out.println(map.get("01"));
        System.out.println("containskey:" + map.containsKey("02"));
        System.out.println("containsvalue:" + map.containsValue("zs1"));
//        map.clear();
        map.remove("01");
        map.put(null, null);
        System.out.println("containskey:" + map.containsKey(null));
        System.out.println("containsvalue:" + map.containsValue(null));
        System.out.println(map);
        Collection<String> values = map.values();
        System.out.println(values);
        Set<String> keys = map.keySet();
        Iterator<String> keyiterator = keys.iterator();
        while (keyiterator.hasNext()) {
            String key = keyiterator.next();
            System.out.println("key:" + key + ",value:" + map.get(key));
        }
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
             Map.Entry<String, String> next = iterator.next();
            System.out.println("key:"+ next.getKey()+",value="+next.getValue());
        }
    }
}
