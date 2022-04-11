package com.jxzj.external.data.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        DynamicProxyUtil dynamicProxyUtil = new DynamicProxyUtil(new UserManagerImpl());

        UserManager instance = (UserManager)dynamicProxyUtil.Instance();
        instance.addUser();
    }
}
