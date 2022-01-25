package com.jxzj.external.data.designmode.abstractfactory.abstrac.impl;

import com.jxzj.external.data.designmode.abstractfactory.abstrac.IRouterProduct;

public class XiaomiRouter implements IRouterProduct {

    @Override
    public void start() {
        System.out.println("小米路由器开机。。。。。。");
    }

    @Override
    public void shutdown() {
        System.out.println("小米路由器关机。。。。。");
    }

    @Override
    public void openWifi() {
        System.out.println("小米路由器开启wifi。。。。。");
    }

    @Override
    public void setting() {
        System.out.println("小米路由器设置。。。。。");
    }

}
