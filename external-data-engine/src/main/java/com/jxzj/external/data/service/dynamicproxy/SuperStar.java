package com.jxzj.external.data.service.dynamicproxy;

public class SuperStar implements Star {

    @Override
    public void sing(String song) {
        System.out.println("明星唱：" + song);

    }

    @Override
    public void act(int money) {
        System.out.println("明星拍戏出场费：" + money);

    }

}
