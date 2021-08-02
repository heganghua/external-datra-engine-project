package com.jxzj.external.data.volatiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {

    public volatile static int count = 0;

    static AtomicInteger cc = new AtomicInteger(0);

    public void m() {
        for (int i = 0; i < 10000; i++) {
            cc.incrementAndGet();
            synchronized (this) {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        VolatileDemo vo = new VolatileDemo();

        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ts.add(new Thread(vo::m, "thread-" + i));
        }

        ts.forEach((o) -> {
            o.start();
        });

        ts.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        System.out.println(count);
    }
}
