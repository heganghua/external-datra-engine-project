package com.jxzj.external.data.java8;

import java.util.Arrays;
import java.util.List;

/**
 * java8新特性
 * 
 * @author heganghua
 * @date 2021/11/11
 */
public class Java8Tester {

    final static String says = "Hello World!";

    public static void main(String[] args) {
        methodReferenceTester();
    }

    /**
     * Function函数式接口
     */
    static void FunctionalInterface() {

    }

    /**
     * Method方法引用
     */
    static void methodReferenceTester() {
        List<String> asList = Arrays.asList("Google", "baidu", "Runoob", "Taobo", "jd");
        asList.forEach(System.out::println);

    }

    /**
     * lambda表达式测试
     */
    void lambdaTester() {
        Java8Tester java8Tester = new Java8Tester();

        // 类型声明
        MathOperation addtino = (int a, int b) -> a + b;
        // 不声明类型
        MathOperation subtraction = (a, b) -> a - b;

        MathOperation multiplication = (a, b) -> {
            return a * b;
        };

        System.out.println(java8Tester.operate(3, 4, addtino));
        System.out.println(java8Tester.operate(3, 4, subtraction));
        System.out.println(java8Tester.operate(3, 4, multiplication));

        GreetingService say = (message) -> System.out.println(says + message);
        say.sayMessage("hhaha ");

        // ===============相当于下面-===========
        GreetingService sg = new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println("say : " + message);
            }
        };
        sg.sayMessage("Hello World!");

        // lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有final 的语义）
        int num = 1;
        Converter<Integer, String> cc = (param) -> System.out.println(String.valueOf(param + num));
        cc.convert(2);
        // num = 5; 加上这句， 报错
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
