package com.jxzj.external.data.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo implements Runnable {

    private static Lock lock = new ReentrantLock();

    CountDownLatch latch;

    public TryLockDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            if (lock.tryLock(4, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "-->");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName() + " time out ");
            }
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            latch.countDown();
        }

    }

}
