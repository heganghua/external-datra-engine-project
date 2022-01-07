package com.jxzj.external.data.thread;

import com.jxzj.external.data.entity.Goods;

public class GoodsConsumer implements Runnable {

    @Override
    public void run() {

        for (;;) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (JustTest.queue) {

                if (!JustTest.queue.isEmpty()) {
                    Goods poll = JustTest.queue.poll();
                    System.out.println(Thread.currentThread().getName() + "消费商品");
                } else {
                    System.out.println("队列已空。。。。。。");
                    JustTest.queue.notifyAll();
                }

            }

        }

    }

}
