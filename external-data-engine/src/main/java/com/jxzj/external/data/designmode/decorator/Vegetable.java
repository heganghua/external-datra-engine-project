package com.jxzj.external.data.designmode.decorator;

public class Vegetable extends Food {

    private Food basicFood;

    public Vegetable(Food basicFood) {
        super();
        this.basicFood = basicFood;
    }

    public String make() {
        return basicFood.make() + " + 蔬菜";
    }

}
