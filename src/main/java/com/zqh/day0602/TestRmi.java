package com.zqh.day0602;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TestRmi {
    public static void main(String[] args) throws RemoteException {
        //双方都必须是java程序 内网使用 1099 安全泄露问题 字节码 数据 恶意构造字节码?
        //rmi remote method invocation 远程方法调用
        //服务端和客户端必须都
        //需要把服务暴露在网络中
        System.out.println("create World clock remote service...");
        WorldClock worldClock = new WorldClockService();
        //转成远程接口
        WorldClock remote = (WorldClock) UnicastRemoteObject.exportObject(worldClock, 0);
        //注册服务到指定接口
        Registry registry=LocateRegistry.createRegistry(1099);//rmi默认端口技就是1099
        //绑定服务名
         registry.rebind("WorldClock",remote);

    }


    //服务类  实现类 称为 skeleton
    static class WorldClockService implements WorldClock {
        @Override
        public LocalDateTime getLocalDateTime(String zoneId) throws RemoteException {
            return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
        }
    }


}
