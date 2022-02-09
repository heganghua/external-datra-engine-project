package com.jxzj.external.data.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args) {

        Class<AnnotationDemo> c = AnnotationDemo.class;

        try {
            Class<?> forName = Class.forName("com.jxzj.external.data.annotation.AnnotationDemo");
            MyAnnotation annotation = forName.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.value());

            Field field = forName.getField("name");
            MyAnnotation filedAnnotation = field.getAnnotation(MyAnnotation.class);
            System.out.println(filedAnnotation.value());

            Method method = forName.getMethod("hello", (Class<?>[])null);
            MyAnnotation methodAnnotation = method.getAnnotation(MyAnnotation.class);
            System.out.println(methodAnnotation.value());

            Method method2 = forName.getMethod("bye", (Class<?>[])null);
            MyAnnotation annotation2 = method2.getAnnotation(MyAnnotation.class);
            System.out.println(annotation2.value());

        } catch (ClassNotFoundException | NoSuchFieldException | SecurityException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
