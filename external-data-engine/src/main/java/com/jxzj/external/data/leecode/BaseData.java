package com.jxzj.external.data.leecode;

public class BaseData {

    public void method() {
        Object o = new Object();
        synchronized (o) {
            System.out.println("synchronized 代码块");
        }
    }

}
