package com.jxzj.external.data.thread;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemoCondition {

    private static final int CAPACITY = 10;

    public static void main(String[] args) {

        Queue queue = new Queue();

        // new Thread(new ProducerThread(queue)).start();
        new Thread(new ProducerThread(queue)).start();
        new Thread(new ConsumerThread(queue)).start();
        // new Thread(new ConsumerThread(queue)).start();

    }

    static class ProducerThread implements Runnable {

        Queue queue;

        ProducerThread(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.putEle(new Random(1000L));
            }
        }
    }

    static class ConsumerThread implements Runnable {

        Queue queue;

        public ConsumerThread(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.takeEle();
            }
        }

    }

    static class Queue {
        final Lock lock = new ReentrantLock();
        Condition pc = lock.newCondition();
        Condition cc = lock.newCondition();
        Object[] container = new Object[CAPACITY];
        int count = 0;
        int putIndex = 0;
        int takeIndex = 0;

        public void putEle(Object ele) {

            try {
                lock.lock();

                while (count == CAPACITY) {
                    System.out.println("???????????????" + count + "????????????????????????????????????" + Thread.currentThread().getName());
                    pc.await();
                }
                container[putIndex] = ele;

                putIndex++;
                if (putIndex >= CAPACITY) {
                    putIndex = 0;
                }
                count++;
                System.out.println("??????????????????" + count);
                System.out.println("?????????????????????????????????");
                cc.signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public Object takeEle() {

            try {
                lock.lock();
                while (count == 0) {
                    System.out.println("????????????" + count + "???????????????????????????????????? " + Thread.currentThread().getName());
                    cc.await();
                }
                Object res = container[takeIndex];
                System.out.println("???????????????%d" + res);
                takeIndex++;
                if (takeIndex >= CAPACITY) {
                    takeIndex = 0;
                }
                count--;
                System.out.println("?????????????????????????????????");
                pc.signalAll();
                return res;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return null;

        }

    }

}
