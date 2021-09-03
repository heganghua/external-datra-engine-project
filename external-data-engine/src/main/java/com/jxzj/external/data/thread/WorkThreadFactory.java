package com.jxzj.external.data.thread;

import java.util.concurrent.ThreadFactory;

public class WorkThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }

}
