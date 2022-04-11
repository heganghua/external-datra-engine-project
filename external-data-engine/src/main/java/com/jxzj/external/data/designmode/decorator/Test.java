package com.jxzj.external.data.designmode.decorator;

public class Test {

    public static void main(String[] args) {

        Bread bread = new Bread(new Cream(new Vegetable(new Food("香肠"))));
        System.out.println(bread.make());
    }
}
