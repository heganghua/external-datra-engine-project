package com.jxzj.external.data.designmode.abstractfactory.abstrac.impl;

import com.jxzj.external.data.designmode.abstractfactory.abstrac.IPhoneProduct;

public class XiaomiPhone implements IPhoneProduct {

    @Override
    public void start() {
        System.out.println("小米手机开机。。。。。。");

    }

    @Override
    public void shutdown() {
        System.out.println("小米手机关机。。。。。。");
    }

    @Override
    public void callup() {
        System.out.println("小米手机打电话。。。。。。");
    }

    @Override
    public void sendSMS() {
        System.out.println("小米手机发送短信。。。。。。");
    }

}
