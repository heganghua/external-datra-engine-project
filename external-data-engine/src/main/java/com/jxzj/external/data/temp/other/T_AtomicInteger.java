package com.jxzj.external.data.temp.other;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class T_AtomicInteger {

    static List<Object> list = new LinkedList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    static Thread t1, t2;

    public static void main(String[] args) {

        T_AtomicInteger ta = new T_AtomicInteger();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 线程启动");
                for (int i = 0; i < 10; i++) {
                    ta.add(new Object());
                    System.out.println("add " + i);
                    if (list.size() == 5) {
                        LockSupport.unpark(t2);
                        LockSupport.park();
                    }
                }
            }
        }, "t1");

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("t2结束。");
                LockSupport.unpark(t1);
            }
        }, "t2");

        t2.start();
        t1.start();
    }
}
