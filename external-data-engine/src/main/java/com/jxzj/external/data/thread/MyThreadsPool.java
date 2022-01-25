package com.jxzj.external.data.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class MyThreadsPool {
    BlockingQueue<Runnable> taskQueue; // 存放任务的阻塞队列
    List<YesThread> threads; // 线程列表

    MyThreadsPool(BlockingQueue<Runnable> taskQueue, int threadSize) {
        this.taskQueue = taskQueue;
        threads = new ArrayList<>(threadSize);
        // 初始化线程，并定义名称
        IntStream.rangeClosed(1, threadSize).forEach((i) -> {
            YesThread thread = new YesThread("yes-task-thread-" + i);
            thread.start();
            threads.add(thread);
        });
    }

    /**
     * 1、核心线程大小 corepoolsize<br>
     * 2、最大线程大小maxipoolsize<br>
     * 3、存活时间， alivetime <br>
     * 4、时间单位，unit <br>
     * 5、同步阻塞工作队列， blockingArrayQueue <br>
     * 6、线程工厂 ThreadFactor<br>
     * 7、拒绝策略 rejectedExecutionHeadle
     * 
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(1 << 29);
        System.out.println(Integer.SIZE);

        // MyThreadsPool mp = new MyThreadsPool(new LinkedBlockingQueue<>(10), 3);
        //
        // IntStream.rangeClosed(1, 5).forEach((i) -> {
        // try {
        // mp.execute(() -> {
        // System.out.println(Thread.currentThread().getName() + " 公众号：yes的练级攻略");
        // });
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // });

    }

    // 提交任务只是往任务队列里面塞任务
    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    class YesThread extends Thread { // 自定义一个线程
        public YesThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) { // 死循环
                Runnable task = null;
                try {
                    task = taskQueue.take(); // 不断从任务队列获取任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("记录点东西.....");
                }
                task.run(); // 执行
            }
        }
    }
}
