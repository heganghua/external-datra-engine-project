package com.jxzj.external.data.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY));

        for (int i = 0; i < 10; i++) {
            // 创建一个WorkerThread对象
            ThreadDemo threadLocalDemo = new ThreadDemo("" + i);
            // 执行Runnable
            threadPool.execute(threadLocalDemo);
        }

        // 终止线程池
        threadPool.shutdown();

        while (threadPool.isTerminated()) {

        }
        System.out.println("Finished all threads");

    }

}
