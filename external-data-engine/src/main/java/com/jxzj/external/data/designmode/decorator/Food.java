package com.jxzj.external.data.designmode.decorator;

public class Food {

    private String foodName;

    public Food() {}

    public Food(String foodName) {
        super();
        this.foodName = foodName;
    }

    public String make() {
        return foodName;
    }

}
