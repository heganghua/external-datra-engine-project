package com.jxzj.external.data.thread;

public class YieldDemo {

    static class Th implements Runnable {
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            int count = 0;
            // for (int i = 0; i < 5000000; i++) {
            // count += i;
            // // Thread.yield();
            //
            // }
            System.out.println("run: " + Thread.currentThread().isAlive());
            long end = System.currentTimeMillis();
            System.out.println("count:" + count + "用时：" + (end - start) + "毫秒！");
        }
    }

    public static void main(String[] args) {
        Th th = new Th();
        Thread t = new Thread(th);
        System.out.println("Begin: " + t.isAlive());
        t.start();
        System.out.println("end: " + t.isAlive());

    }

}
