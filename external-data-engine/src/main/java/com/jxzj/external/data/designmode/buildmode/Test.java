package com.jxzj.external.data.designmode.buildmode;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        MilkTea milkTea = new MilkTea.Builder("原味奶茶").build();
        String pearl;
        if (milkTea.isPearl())
            pearl = "加珍珠";
        else
            pearl = "不加珍珠";
        String ice;
        if (milkTea.isIce()) {
            ice = "加冰";
        } else {
            ice = "不加冰";
        }
        System.out.println("一份" + milkTea.getSize() + "、" + pearl + "、" + ice + "的" + milkTea.getType() + "奶茶");

        MilkTea clone = (MilkTea)milkTea.clone();
        System.out.println(clone.toString());

        Computer computer =
            new Computer.Builder("英特尔", "三星").setDisplay("三星").setKeyboard("妇科圣手").setUsbCount(3).build();

        System.out.println(computer.toString());

        User user = new User();
        user.setSex("女");
        user.setName("Lucy");
        user.setHome(new Home("湖南", "长沙", "岳麓区"));
        System.out.println(user.toString());

        Object clone2 = user.clone();
        System.out.println(clone2);
        // 五种构建型模式
        // 1，工厂模式(简单工厂模式、工厂方法模式、抽象工厂模式)
        // 2、单例模式
        // 3、 建造型模式
        // 4、原先模式

    }

}
