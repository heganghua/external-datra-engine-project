package com.jxzj.external.data.thread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import com.jxzj.external.data.entity.Goods;

public class JustTest {

    public static final int MAX_POOL = 10;
    public static final int MAX_PRODUCER = 5;
    public static final int MAX_CONSUMER = 4;
    public static Queue<Goods> queue = new ArrayBlockingQueue<Goods>(MAX_POOL);

    public static void main(String[] args) {

        GoodsProducer p = new GoodsProducer();
        GoodsConsumer c = new GoodsConsumer();

        for (int i = 0; i < MAX_PRODUCER; i++) {
            Thread thread = new Thread(p, "生产着线程" + i);
            thread.start();
        }

        for (int j = 0; j < MAX_CONSUMER; j++) {
            new Thread(c, "消费者线程" + j).start();
        }

    }
}
