package com.jxzj.external.data.thread;

import java.util.Date;
import java.util.stream.IntStream;

public class ThreadDemo implements Runnable {

    private String command;

    public ThreadDemo(String command) {
        super();
        this.command = command;
    }

    public static void main(String[] args) {

        IntStream.rangeClosed(0, 5).forEach((i) -> {
            new Thread(new ThreadDemo(String.valueOf(i))).start();
        });
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
