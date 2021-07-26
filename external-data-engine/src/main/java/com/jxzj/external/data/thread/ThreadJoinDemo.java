package com.jxzj.external.data.thread;

public class ThreadJoinDemo {
    public static void main(String[] args) {

        MyThread3 my3 = new MyThread3();
        Thread t1 = new Thread(my3, "线程A");
        t1.start();
        for (int i = 0; i < 50; i++) {
            if (i > 10) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "Main线程运行 ———>" + i);
        }
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}