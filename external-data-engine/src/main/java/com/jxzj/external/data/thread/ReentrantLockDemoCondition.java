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
                    System.out.println("队列已满：" + count + "，生产者开始睡大觉。。。" + Thread.currentThread().getName());
                    pc.await();
                }
                container[putIndex] = ele;

                putIndex++;
                if (putIndex >= CAPACITY) {
                    putIndex = 0;
                }
                count++;
                System.out.println("生产一个元素" + count);
                System.out.println("通知消费者去消费。。。");
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
                    System.out.println("队列为空" + count + "，消费者开始睡大觉。。。 " + Thread.currentThread().getName());
                    cc.await();
                }
                Object res = container[takeIndex];
                System.out.println("消费元素：%d" + res);
                takeIndex++;
                if (takeIndex >= CAPACITY) {
                    takeIndex = 0;
                }
                count--;
                System.out.println("通知生产者去生产。。。");
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
