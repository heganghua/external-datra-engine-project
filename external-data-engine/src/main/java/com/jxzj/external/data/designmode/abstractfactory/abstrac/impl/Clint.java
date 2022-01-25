package com.jxzj.external.data.designmode.abstractfactory.abstrac.impl;

import com.jxzj.external.data.designmode.abstractfactory.abstrac.IPhoneProduct;
import com.jxzj.external.data.designmode.abstractfactory.abstrac.IRouterProduct;

public class Clint {
    public static void main(String[] args) {

        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IPhoneProduct productPhone = xiaomiFactory.productPhone();
        productPhone.start();
        productPhone.sendSMS();

        HuaweiFactory huaweiFactory = new HuaweiFactory();
        IRouterProduct productRouter = huaweiFactory.productRouter();
        productRouter.start();

        AppleFactory appleFactory = new AppleFactory();
        IPhoneProduct iphone = appleFactory.productPhone();
        iphone.callup();
        iphone.sendSMS();

    }
}
