package com.jxzj.external.data.thread;

import com.jxzj.external.data.entity.Goods;

public class GoodsProducer implements Runnable {

    private Goods goods;

    @Override
    public void run() {

        for (;;) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (JustTest.queue) {

                goods = new Goods(1L, "商品");

                if (JustTest.queue.size() < JustTest.MAX_POOL) {
                    JustTest.queue.add(goods);
                    System.out.println(Thread.currentThread().getName() + "生产商品");
                } else {
                    System.out.println("队列已满。。。。。。");
                    try {
                        JustTest.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

    }

}
