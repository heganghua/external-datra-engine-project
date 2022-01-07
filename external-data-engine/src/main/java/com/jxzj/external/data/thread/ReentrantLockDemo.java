package com.jxzj.external.data.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 reentrantLock demo
 * 
 * @author hgh
 * @date 2022/01/04
 */
public class ReentrantLockDemo {

    public static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        // for (int i = 0; i < 3; i++) {
        // new Thread(() -> test(), "线程A_" + i).start();
        // }

        // for (int i = 0; i < 10; i++) {
        // new Thread(() -> fairLock(), "线程_" + i).start();
        // }

        new Thread(() -> fairLock(), "线程_A").start();
        new Thread(() -> fairLock(), "线程_B").start();
        new Thread(() -> fairLock(), "线程_C").start();
        new Thread(() -> fairLock(), "线程_D").start();
        new Thread(() -> fairLock(), "线程_E").start();
    }

    /**
     * 公平锁
     */
    public static void fairLock() {
        for (int i = 0; i < 2; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得了锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 简单使用
     */
    public static void test() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
            System.out.println(Thread.currentThread().getName() + "处理业务逻辑中。。。。");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

}
