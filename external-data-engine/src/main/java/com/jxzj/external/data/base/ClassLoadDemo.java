package com.jxzj.external.data.base;

public class ClassLoadDemo {

    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoadDemo.class.getClassLoader();
        System.out.println(classLoader.toString());
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

    }

}
