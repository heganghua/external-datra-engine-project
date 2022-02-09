package com.jxzj.external.data.designmode.proxymode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {

    public static void main(String[] args) {

        // 创建一个代理柜台，销售茅台酒
        InvocationHandler proxyCounter = new ProxyCounter(new Maotai());
        SellWine newProxyInstance =
            (SellWine)Proxy.newProxyInstance(Maotai.class.getClassLoader(), Maotai.class.getInterfaces(), proxyCounter);
        newProxyInstance.sell();
        System.out.println("-----------------------------");

        ProxyCounter proxyCounter2 = new ProxyCounter(new Wuliangye());
        SellWine p2 = (SellWine)Proxy.newProxyInstance(Wuliangye.class.getClassLoader(),
            Wuliangye.class.getInterfaces(), proxyCounter2);
        p2.sell();
        System.out.println("-----------------------------");

        ProxyCounter furongwang = new ProxyCounter(new FurongWang());
        SellCigarette furongWangProxy = (SellCigarette)Proxy.newProxyInstance(FurongWang.class.getClassLoader(),
            FurongWang.class.getInterfaces(), furongwang);
        furongWangProxy.sellCigarette();
    }

    /**
     * 这相当于一个代理类，
     * 
     * @author hgh
     * @date 2022/01/28
     */
    public static class ProxyCounter implements InvocationHandler {

        public Object o;

        public ProxyCounter(Object o) {
            super();
            this.o = o;
        }

        @Override
        public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
            System.out.println("这个是代理柜台， 这个柜台需要打广告，——》 “这是广告”........");
            arg1.invoke(o, arg2);
            System.out.println("卖完了， 再打一波广告。——》 “这是广告位，广告位招租”........");
            return null;
        }
    }

    static class Wuliangye implements SellWine {

        @Override
        public void sell() {
            System.out.println("我们卖的是五粮液。。。。， 不是其他的杂牌");
        }
    }

    /**
     * 被代理的类， 处理的具体业务逻辑
     * 
     * @author hgh
     * @date 2022/01/28
     */
    public static class Maotai implements SellWine {
        @Override
        public void sell() {
            // 业务逻辑
            System.out.println("我卖的是53°飞天茅台。。。。。");
        }
    }

    static interface SellWine {
        void sell();
    }

    static class FurongWang implements SellCigarette {

        @Override
        public void sellCigarette() {
            System.out.println("湖南人怎么可能不买芙蓉王。。。。。");
        }
    }

    static interface SellCigarette {
        void sellCigarette();
    }

}
