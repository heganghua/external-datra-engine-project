package com.jxzj.external.data.designmode.abstractfactory;

/**
 * 具体工厂类，可以生产不同类别的产品
 * 
 * @author heganghua
 * @date 2021/07/21
 */
public class SGfarm implements Farm {

    @Override
    public Animal newAnimal() {
        System.out.println("新牛出现！！！");
        return new Cow();
    }

    @Override
    public Plant newPlant() {
        System.out.println("蔬菜成长");
        return new Vegetables();
    }

}
