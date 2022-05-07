package com.jxzj.external.data.designmode.decorator;

/**
 * 装饰器模式
 * 
 * @author hgh
 * @date 2022/04/11
 */
public class Test {

    public static void main(String[] args) {

        Bread bread = new Bread(new Cream(new Vegetable(new Food("香肠"))));
        System.out.println(bread.make());
    }
}
