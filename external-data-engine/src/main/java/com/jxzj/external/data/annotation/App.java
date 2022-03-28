package com.jxzj.external.data.annotation;

public class App {

    public static void main(String[] args) {

        String s = "123";
        String s2 = new String("123");
        System.out.println(s2.equals(s));
        System.out.println(s2 == s);

        int i = 1;
        Integer i1 = 1;
        System.out.println(i == i1);
        System.out.println(i1.equals(1));

        // AnnotationConfigApplicationContext applicationContext = new
        // AnnotationConfigApplicationContext(AppConfig.class);
        // Tom tom = applicationContext.getBean(Tom.class);
        // System.out.println(tom.toString());

    }

}
