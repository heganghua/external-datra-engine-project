package com.jxzj.external.data.thread;

/**
 * 匿名表达式
 * 
 * @author heganghua
 * @date 2021/07/26
 */
public class ThreadLabmadaDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread(() -> {
            System.out.println("hhh");
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
