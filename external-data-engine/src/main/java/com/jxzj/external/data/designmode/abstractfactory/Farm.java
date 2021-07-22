package com.jxzj.external.data.designmode.abstractfactory;

/**
 * 抽象工厂:农场类
 * 
 * @author heganghua
 * @date 2021/07/21
 */
public interface Farm {

    public Animal newAnimal();

    public Plant newPlant();
}
