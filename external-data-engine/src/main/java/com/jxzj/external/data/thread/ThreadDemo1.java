package com.jxzj.external.data.thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("线程A");
        MyThread1 t2 = new MyThread1("线程B");

        t1.start();
        t2.start();

    }
}

class MyThread1 extends Thread {

    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行，i = " + i + Thread.currentThread().getName());
        }
    }

}
