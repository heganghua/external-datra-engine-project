package com.jxzj.external.data.designmode.abstractfactory.abstrac.impl;

import com.jxzj.external.data.designmode.abstractfactory.abstrac.IPhoneProduct;
import com.jxzj.external.data.designmode.abstractfactory.abstrac.IProductFactory;
import com.jxzj.external.data.designmode.abstractfactory.abstrac.IRouterProduct;

public class HuaweiFactory implements IProductFactory {

    @Override
    public IPhoneProduct productPhone() {
        System.out.println("生产华为手机。。。。");
        HuaweiPhone huaweiPhone = new HuaweiPhone();
        return huaweiPhone;
    }

    @Override
    public IRouterProduct productRouter() {
        System.out.println("生产华为路由器。。。。");
        HuaweiRouter huaweiRouter = new HuaweiRouter();
        return huaweiRouter;
    }

}
