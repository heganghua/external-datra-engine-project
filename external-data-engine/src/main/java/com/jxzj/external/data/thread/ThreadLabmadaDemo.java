package com.jxzj.external.data.thread;

import java.util.concurrent.TimeUnit;

/**
 * 匿名表达式
 * 
 * @author heganghua
 * @date 2021/07/26
 */
public class ThreadLabmadaDemo {

    int count = 0;

    synchronized void m() {
        while (true) {
            count++;
            if (count == 5) {
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = 1 / 0;
                System.out.println(i);
            }
            System.out.println(Thread.currentThread().getName() + count);
        }
    }

    public static void main(String[] args) {
        ThreadLabmadaDemo t = new ThreadLabmadaDemo();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(() -> {
            t.m();
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new Thread(r1, "t2").start();
    }
}
