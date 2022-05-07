package com.jxzj.external.data.designmode.decorator;

public class Bread extends Food {

    private Food basicFood;

    public Bread(Food basicFood) {
        super();
        this.basicFood = basicFood;
    }

    public String make() {
        return basicFood.make() + " + 面包";

    }

}
