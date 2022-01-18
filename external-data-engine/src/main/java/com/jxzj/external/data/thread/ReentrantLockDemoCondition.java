package com.jxzj.external.data.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemoCondition {

    static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Condition pc = lock.newCondition();
        Condition cc = lock.newCondition();

    }

    static class ProducerThread implements Runnable {

        Condition c;

        public ProducerThread(Condition c) {
            super();
            this.c = c;
        }

        @Override
        public void run() {
            try {
                firstLock.lockInterruptibly();
                System.out.println("firstLock Interruptibly....");
                TimeUnit.SECONDS.sleep(2);
                secondLock.lockInterruptibly();
                System.out.println("secondLock Interruptibly...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName() + "获取到了资源，正常结束");
            }
        }
    }

    static class ConsumerThread implements Runnable {

        @Override
        public void run() {

        }

    }

}
