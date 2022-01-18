package com.jxzj.external.data.thread;

import java.util.Date;

public class ThreadLocalDemo implements Runnable {

    private String command;

    public ThreadLocalDemo(String command) {
        super();
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ThreadLocalDemo [command=" + command + "]";
    }

}
