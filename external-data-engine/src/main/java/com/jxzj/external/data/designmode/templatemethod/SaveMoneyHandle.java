package com.jxzj.external.data.designmode.templatemethod;

public class SaveMoneyHandle extends AbstractBusinessHandler {

    @Override
    protected void handle() {
        System.out.println("save 100");
    }

    public static void main(String[] args) {

        // SaveMoneyHandle sm = new SaveMoneyHandle();
        // sm.execute();

        AbstractBusinessHandler2 handler2 = new AbstractBusinessHandler2();
        handler2.save(1000L);

    }

}
