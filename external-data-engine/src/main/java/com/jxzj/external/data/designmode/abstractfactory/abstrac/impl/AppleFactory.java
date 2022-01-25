package com.jxzj.external.data.designmode.abstractfactory.abstrac.impl;

import com.jxzj.external.data.designmode.abstractfactory.abstrac.IPhoneProduct;
import com.jxzj.external.data.designmode.abstractfactory.abstrac.IProductFactory;
import com.jxzj.external.data.designmode.abstractfactory.abstrac.IRouterProduct;

public class AppleFactory implements IProductFactory {

    @Override
    public IPhoneProduct productPhone() {
        System.out.println("生产苹果手机。。。。");
        ApplePhone applePhone = new ApplePhone();
        return applePhone;
    }

    @Override
    public IRouterProduct productRouter() {
        System.out.println("生产苹果路由器。。。。");
        return new AppleRouter();
    }

}
