package com.jxzj.external.data.designmode.templatemethod;

import org.apache.commons.lang3.RandomUtils;

public abstract class AbstractBusinessHandler {

    public final void execute() {
        getNumber();
        handle();
        judge();
    }

    private void judge() {
        System.out.println("give a praised");
    }

    protected abstract void handle();

    private void getNumber() {
        System.out.println("number-00" + RandomUtils.nextInt());
    }

}
