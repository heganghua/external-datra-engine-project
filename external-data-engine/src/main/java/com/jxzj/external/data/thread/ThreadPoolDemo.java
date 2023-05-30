package com.jxzj.external.data.thread;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        int corePoolSize = 3;
        int maximumPoolSize = 6;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        // 有界阻塞队列
        LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        // 线程工厂，自定义线程
        NameTreadFactory threadFactory = new NameTreadFactory();
        // 拒绝策略
        MyIgnorePolicy handle = new MyIgnorePolicy();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
            workQueue, threadFactory, handle);
        // 预启动所有核心线程
        threadPool.prestartAllCoreThreads();

        for (int i = 1; i <= 10; i++) {
            MyTask myTask = new MyTask(String.valueOf(i));
            threadPool.execute(myTask);
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程工厂， 创建特殊名字的线程
     * 
     * @author ganghua
     * @date 2023/02/06
     */
    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");

            return t;
        }
    }

    static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            doLog(r, executor);
        }

        private void doLog(Runnable r, ThreadPoolExecutor executor) {
            // 做日志记录等
            System.out.println(r.toString() + " rejected");
        }
    }

    /**
     * 业务逻辑
     * 
     * @author ganghua
     * @date 2023/02/06
     */
    static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            try {
                System.out.println(this.toString() + " is running!");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }

    }

}
