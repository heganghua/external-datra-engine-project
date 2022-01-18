package com.jxzj.external.data.thread;

/**
 * interrupt,线程中断
 * 
 * @author hgh
 * @date 2022/01/10
 */
public class DDemo implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "进入暂停。。。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "收到中断异常。。。。。");
            System.out.println(Thread.currentThread().getName() + "做一些相关处理。。。");
            e.printStackTrace();
        }

    }

}
