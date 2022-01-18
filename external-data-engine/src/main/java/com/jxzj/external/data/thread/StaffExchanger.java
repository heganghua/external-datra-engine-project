package com.jxzj.external.data.thread;

import java.util.concurrent.Exchanger;

public class StaffExchanger implements Runnable {

    private String name;
    private Exchanger<Tool> ex;
    private Tool tool;

    public StaffExchanger(String name, Exchanger<Tool> ex, Tool tool) {
        super();
        this.name = name;
        this.ex = ex;
        this.tool = tool;
    }

    @Override
    public void run() {

        try {
            System.out.println("开始工作" + name + ": " + tool.name + ": " + tool.work);
            Thread.sleep(2000);
            System.out.println("开始交换工具。。。。");
            tool = ex.exchange(tool);

            System.out.println("交换工具后开始工作" + name + ": " + tool.name + ": " + tool.work);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Tool {
        private String name;
        private String work;

        public Tool(String name, String work) {
            super();
            this.name = name;
            this.work = work;
        }
    }

}
