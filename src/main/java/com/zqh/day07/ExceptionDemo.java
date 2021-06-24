package com.zqh.day07;

import java.util.concurrent.TimeoutException;

public class ExceptionDemo {
    public static void main(String[] args) throws TimeoutException {
/*        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 2)
                System.exit(0);
        }*/
        Bexception dsad = new Bexception("dsad");
        dsad.method();
    }
}

class Aexception extends Exception {
    Aexception(String msg) {
        super(msg);
    }

    void method() {
        System.out.println("method  in fu");
    }
}

class Bexception extends Aexception {

    Bexception(String msg) {
        super(msg);
    }

    @Override
    void method() {
        System.out.println("==============");
        try {
            throw new TimeoutException();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
