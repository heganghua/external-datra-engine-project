package com.jxzj.external.data.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemoCondition {

    static final Lock clock = new ReentrantLock();
    static final Lock pLock = new ReentrantLock();
    private static final int CAPACITY = 10;

    public static void main(String[] args) {

        // container[0] = "licy";
        // Object[] cpoy = container;
        // cpoy[1] = "wuli";
        // System.out.println(Arrays.toString(container));
        // System.out.println(Arrays.toString(cpoy));

    }

    static class ProducerThread implements Runnable {

        Condition cc;
        Condition pc;
        Lock pLock;
        Object[] container;

        public ProducerThread(Condition pc, Condition cc, Lock pLock, Object[] container) {
            super();
            this.pc = pc;
            this.cc = cc;
            this.pLock = pLock;
            this.container = container;
        }

        @Override
        public void run() {
            for (;;) {

            }

        }
    }

    static class ConsumerThread implements Runnable {
        @Override
        public void run() {

        }

    }

    static class Queue {

        Condition pc = pLock.newCondition();
        Condition cc = clock.newCondition();
        Object[] container = new Object[CAPACITY];
        int count = 0;
        int putIndex = 0;
        int takeIndex = 0;

        public void putEle(Object ele) {

        }

        public void takeEle() {

        }

    }

}
