package com.jxzj.external.data.designmode.decorator;

public class Bread extends Food {

    private Food basicFood;

    public Bread(Food basicFood) {
        super();
        System.out.println("basicFood 有参构造方法");
        this.basicFood = basicFood;
    }

    public String make() {
        return basicFood.make() + " + 面包";

    }

}
