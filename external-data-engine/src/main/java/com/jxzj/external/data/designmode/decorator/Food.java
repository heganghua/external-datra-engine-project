package com.jxzj.external.data.designmode.decorator;

public class Food {

    private String foodName;

    public Food() {}

    public Food(String foodName) {
        super();
        System.out.println("Food 有参构造方法");
        this.foodName = foodName;
    }

    public String make() {
        return foodName;
    }

}
