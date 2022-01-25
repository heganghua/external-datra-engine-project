package com.jxzj.external.data.designmode.abstractfactory.abstrac.impl;

import com.jxzj.external.data.designmode.abstractfactory.abstrac.IPhoneProduct;
import com.jxzj.external.data.designmode.abstractfactory.abstrac.IProductFactory;
import com.jxzj.external.data.designmode.abstractfactory.abstrac.IRouterProduct;

public class XiaomiFactory implements IProductFactory {

    @Override
    public IPhoneProduct productPhone() {
        System.out.println("生产小米手机。。。。");
        XiaomiPhone xiaomiPhone = new XiaomiPhone();
        return xiaomiPhone;
    }

    @Override
    public IRouterProduct productRouter() {
        System.out.println("生产小米路由器。。。。");
        XiaomiRouter xiaomiRouter = new XiaomiRouter();
        return xiaomiRouter;
    }

}
