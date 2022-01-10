package com.jxzj.external.data.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {

    static final Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadDemo(lock1, lock2));
        Thread t2 = new Thread(new ThreadDemo(lock2, lock1));

        t1.start();
        t2.start();
        // t1 线程中断
        System.out.println("手动中断线程t1");
        t1.interrupt();
    }

    static class ThreadDemo implements Runnable {

        Lock firstLock;
        Lock secondLock;

        public ThreadDemo(Lock firstLock, Lock secondLock) {
            super();
            this.firstLock = firstLock;
            this.secondLock = secondLock;
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

}
