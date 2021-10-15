package com.jxzj.external.data.jvm;

public class ClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        System.out.println(contextClassLoader.getParent());
        System.out.println(contextClassLoader.getParent().getParent());

    }

}
