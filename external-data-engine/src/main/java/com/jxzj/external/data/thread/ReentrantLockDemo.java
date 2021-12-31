package com.jxzj.external.data.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(() -> test(), "线程A_" + i).start();
        }

    }

    public static void test() {

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

}
