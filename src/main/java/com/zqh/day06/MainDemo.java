package com.zqh.day06;

public class MainDemo {
    public static void main(String[] args) {
        MainBoard mainBoard = new MainBoard();
        mainBoard.run();
        mainBoard.usePci(new NetCard());
        mainBoard.usePci(new SoundCard());
    }
}

class MainBoard {

    public void run() {
        System.out.println("main is running");
    }

    public void usePci(Pci pci) {   //接口型引指向自己的子类对象！
        if (pci != null) {
            pci.open();
            pci.close();
        }
    }
}

interface Pci {
    void open();

    void close();
}

class NetCard implements Pci {
    public void open() {
        System.out.println("netcard open");
    }

    public void close() {
        System.out.println("netcard close");
    }
}

class SoundCard implements Pci {
    @Override
    public void open() {
        System.out.println("soundcard open");
    }

    @Override
    public void close() {
        System.out.println("soundcard close");
    }
}






