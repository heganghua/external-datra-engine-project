package com.jxzj.external.data.leecode;

import java.util.concurrent.locks.ReentrantLock;

public class BaseData {

    public void method() {
        Object o = new Object();

        ReentrantLock reentrantLock = new ReentrantLock();
        synchronized (o) {
            System.out.println("synchronized 代码块");
        }
    }

}
