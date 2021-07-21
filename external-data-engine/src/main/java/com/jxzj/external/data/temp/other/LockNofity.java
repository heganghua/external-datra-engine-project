package com.jxzj.external.data.temp.other;

import java.util.LinkedList;
import java.util.List;

public class LockNofity {

    List<Object> list = new LinkedList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {

        Object lock = new Object();
        LockNofity ln = new LockNofity();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1线程启动");
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        ln.add(new Object());
                        System.out.println("add" + i);
                        if (ln.size() == 5) {
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "t1");

        new Thread(() -> {

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("t2线程启动");
                    if (ln.size() != 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t2线程结束");
                    lock.notify();
                }
            }
        }, "t2");

        t2.start();
        t1.start();

    }

}
