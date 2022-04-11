package com.jxzj.external.data.designmode.decorator;

public class Cream extends Food {

    private Food basicFood;

    public Cream(Food basicFood) {
        super();
        this.basicFood = basicFood;
    }

    public String make() {
        return basicFood.make() + "+ 奶油";
    }

}
