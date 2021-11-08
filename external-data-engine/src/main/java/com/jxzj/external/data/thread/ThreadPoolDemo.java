package com.jxzj.external.data.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public void test1() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3, new WorkThreadFactory());
        for (int i = 0; i < 10; i++) {
            Future<Long> submit = newFixedThreadPool.submit(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name + "执行了任务");
                return System.currentTimeMillis();
            });
            try {
                System.out.println(submit.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        newFixedThreadPool.shutdown();
    }

    public static void testArrayBlockingQueue() {
        ThreadPoolExecutor e =
            new ThreadPoolExecutor(20, 20, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1)) {
                @Override
                protected void beforeExecute(Thread t, Runnable r) {
                    System.out.println("beforeExecute is called");
                }

                @Override
                protected void afterExecute(Runnable r, Throwable t) {
                    System.out.println("aterExecute is called");
                }

                @Override
                protected void terminated() {
                    System.out.println("terminated is called");
                }
            };
        e.execute(() -> {
            System.out.println("this is a task");
        });
        e.shutdown();
    }

    public static void testHandler() {
        // new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1), );
    }

    public static void main(String[] args) {
        // ThreadPoolDemo.testArrayBlockingQueue();
        // System.out.println(Runtime.getRuntime().availableProcessors());

        Executors.newCachedThreadPool();

        // new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)

    }
}
