package com.jxzj.external.data.designmode.signleton;

public class Mgr01 {

    // static final Mgr01 INSTANCE;
    //
    // static {
    // INSTANCE = new Mgr01();
    // }

    public static void main(String[] args) {
        EnumSignleton instance2 = EnumSignleton.INSTANCE;

        EnumSignleton instance3 = EnumSignleton.INSTANCE;
        System.out.println(instance3 == instance2);

        instance2.sayHello();
    }

}
