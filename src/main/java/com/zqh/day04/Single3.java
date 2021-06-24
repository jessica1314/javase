package com.zqh.day04;


/**
 * 二段式检测单例
 */
public class Single3 {
    private Single3() {

    }

    private static Single3 single = null;

    /**
     * @return 返回该类实例
     */
    public static Single3 getInstance() {
        if (null == single) {
            synchronized (Single3.class) {
                if (null == single) {
                    single = new Single3();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) {
        System.out.println(Single3.getInstance());
        System.out.println(Single3.getInstance());
    }
}
