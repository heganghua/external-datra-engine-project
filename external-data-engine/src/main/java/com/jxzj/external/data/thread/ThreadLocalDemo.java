package com.jxzj.external.data.thread;

public class ThreadLocalDemo {

    public static void main(String[] args) {

        // ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<Object> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("123");

        new Thread(() -> {
            System.out.println(inheritableThreadLocal.get());
        }).start();
    }

}
