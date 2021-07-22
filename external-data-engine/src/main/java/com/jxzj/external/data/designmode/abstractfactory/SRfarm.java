package com.jxzj.external.data.designmode.abstractfactory;

public class SRfarm implements Farm {

    @Override
    public Animal newAnimal() {
        System.out.println("新马出现！！！");
        return new Horse();
    }

    @Override
    public Plant newPlant() {
        System.out.println("水果成长！！！！");
        return new Fruitage();
    }

}
