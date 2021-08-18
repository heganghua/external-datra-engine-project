package com.jxzj.external.data.thread;

import java.util.concurrent.ThreadPoolExecutor;

public class JustTest {
    public static void main(String[] args) {
        Object o = new Object();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 0, 0, null, null);
    }
}
