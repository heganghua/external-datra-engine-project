package com.jxzj.external.data.thread;

import java.util.concurrent.TimeUnit;

/**
 * 比较 notify 和notifyAll的区别
 * 
 * @author hgh
 * @date 2022/12/31
 */
public class NotifyDemo {

    public static void main(String[] args) {

        Object o = new Object();

        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread("Thread" + i, o);
            t.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("main thread notify.........");
            synchronized (o) {
                // 只唤醒一个线程
                // o.notify();
                o.notifyAll();
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println("main Thread is end. ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class MyThread extends Thread {

        private String name;
        private Object co;

        public MyThread(String name, Object co) {
            this.name = name;
            this.co = co;
        }

        @Override
        public void run() {
            System.out.println(name + "is waiting");

            synchronized (co) {
                try {
                    co.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " has been notified.");
            }
        }

    }

}
