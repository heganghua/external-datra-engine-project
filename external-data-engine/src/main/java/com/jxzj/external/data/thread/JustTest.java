package com.jxzj.external.data.thread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

import com.jxzj.external.data.entity.Goods;

public class JustTest {

    public static final int MAX_POOL = 10;
    public static final int MAX_PRODUCER = 5;
    public static final int MAX_CONSUMER = 4;
    public static Queue<Goods> queue = new ArrayBlockingQueue<Goods>(MAX_POOL);

    static Exchanger<StaffExchanger.Tool> ex = new Exchanger<>();
    public static final CountDownLatch cd = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        TryLockDemo tl = new TryLockDemo(cd);
        new Thread(tl, "Thread_A").start();
        new Thread(tl, "Thread_B").start();
        JustTest.class.wait();
        System.out.println("over");
        // new Thread(new StaffExchanger("大胖", ex, new StaffExchanger.Tool("扫帚", "扫地"))).start();
        // new Thread(new StaffExchanger("小受", ex, new StaffExchanger.Tool("抹布", "擦桌子"))).start();
        // new Thread(new StaffExchanger("中子", ex, new StaffExchanger.Tool("锅", "煮饭"))).start();

        // CyclicBarrier cb = new CyclicBarrier(5, new Runnable() {
        // @Override
        // public void run() {
        // System.out.println(Thread.currentThread().getName() + " 最后完成任务， 跳舞");
        // }
        // });
        // for (int i = 0; i < 5; i++) {
        // Thread t = new Thread(new StaffCyclicBarrier(cb, i));
        // t.start();
        // }
        // synchronized (JustTest.class) {
        // JustTest.class.wait();
        // }

        // CountDownLatch cdl = new CountDownLatch(100);
        // ExecutorService e = Executors.newCachedThreadPool();
        // for (int i = 0; i < 100; i++) {
        // CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo(cdl);
        // // new Thread(countDownLatchDemo).start();
        // e.execute(countDownLatchDemo);
        // }

        // DDemo dDemo = new DDemo();
        // Thread t1 = new Thread(dDemo);
        // t1.start();
        // try {
        // Thread.sleep(2);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // System.out.println("回到主线程。。。。。");
        // t1.interrupt();

        // GoodsProducer p = new GoodsProducer();
        // GoodsConsumer c = new GoodsConsumer();
        //
        // for (int i = 0; i < MAX_PRODUCER; i++) {
        // Thread thread = new Thread(p, "生产着线程" + i);
        // thread.start();
        // }
        //
        // for (int j = 0; j < MAX_CONSUMER; j++) {
        // new Thread(c, "消费者线程" + j).start();
        // }

    }
}
