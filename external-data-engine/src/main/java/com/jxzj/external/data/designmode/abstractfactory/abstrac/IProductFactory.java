package com.jxzj.external.data.designmode.abstractfactory.abstrac;

public interface IProductFactory {

    /**
     * 生产手机
     * 
     * @return
     */
    IPhoneProduct productPhone();

    /**
     * 生产路由器
     * 
     * @return
     */
    IRouterProduct productRouter();

}
