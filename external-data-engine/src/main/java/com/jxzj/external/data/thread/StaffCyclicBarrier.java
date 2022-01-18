package com.jxzj.external.data.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 循环栅栏<br>
 * 
 * 让所有线程等待完成后才会继续下一步行动， 可以指定最后一个到达线程要做的任务。
 * 
 * @author hgh
 * @date 2022/01/10
 */
public class StaffCyclicBarrier implements Runnable {

    private CyclicBarrier cb;

    private int num;

    public StaffCyclicBarrier(CyclicBarrier cb, int num) {
        super();
        this.cb = cb;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3);
            System.out.println(Thread.currentThread().getName() + ":   _" + num);
            cb.await();

            Thread.sleep(3);
            System.out.println(Thread.currentThread().getName() + ":   _" + num);
            cb.await();

            Thread.sleep(3);
            System.out.println(Thread.currentThread().getName() + ":   _" + num);
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + num);
    }

}
