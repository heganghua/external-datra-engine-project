package com.jxzj.external.data.temp.other;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T_ReentranLock<T> {

    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition product = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        try {
            lock.lock();
            while (list.size() == MAX) {
                product.await();
            }
            list.add(t);
            ++count;
            // consumer.notifyAll();
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (list.size() == 0) {
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            // 通知生产者进行生产
            product.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        T_ReentranLock<String> c = new T_ReentranLock<>();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        System.out.println(c.get() + "    " + j);
                    }
                }
            }, "p" + i).start();
        }

        for (int x = 0; x < 2; x++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int y = 0; y < 15; y++) {
                        c.put(Thread.currentThread().getName() + "@" + y);
                    }
                }
            }, "c" + x).start();
        }

    }

}
