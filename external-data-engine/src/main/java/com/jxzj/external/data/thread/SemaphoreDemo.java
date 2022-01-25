package com.jxzj.external.data.thread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo implements Runnable {

    private static final int COUNT = 20;

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
            new ThreadPoolExecutor(COUNT, COUNT, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        // 指定最多只有五个线程同时执行
        Semaphore semaphore = new Semaphore(5);
        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            final int no = i;
            executor.execute(() -> {
                try {
                    // 获得许可
                    semaphore.acquire();

                    System.out.println(no + ": 号车可通行");
                    Thread.sleep(10 * 1000);
                    // 释放许可
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    @Override
    public void run() {}
}
