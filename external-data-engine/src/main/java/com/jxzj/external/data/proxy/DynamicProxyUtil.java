package com.jxzj.external.data.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyUtil implements InvocationHandler {

    private Object obj;

    public DynamicProxyUtil(Object obj) {
        super();
        this.obj = obj;
    }

    /**
     * 绑定关系<br>
     * 也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法
     * 
     * @return 动态代理的接口对象
     */
    public Object Instance() {
        // 该方法用于为指定类加载器， 一组接口及调用处理器生成动态代理类实例
        // 第一个参数指定生产对象的类加载器，需要将其指定为和目标对象同一个类加载器。
        // 第二个参数要实现和目标对象的一样的接口，所以只需要拿到目标对象的实现接口。
        // 第三个参数表明这些被拦截的方法在拦截时需要执行哪个InvocationHandler的invoke方法。
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("在这里做些什么事？");

        return method.invoke(obj, args);
    }

}
