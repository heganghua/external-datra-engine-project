package com.jxzj.external.data.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo implements Runnable {

    private CountDownLatch cdl;

    public CountDownLatchDemo(CountDownLatch cdl) {
        super();
        this.cdl = cdl;
    }

    @Override
    public void run() {

        try {
            // synchronized (cdl) {
            cdl.countDown();
            System.out.println("Thrad counts = " + (cdl.getCount()));
            // }
            cdl.await();
            System.out.println("concurrency counts = " + (100 - cdl.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
