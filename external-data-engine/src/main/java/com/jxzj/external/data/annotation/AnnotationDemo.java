package com.jxzj.external.data.annotation;

@MyAnnotation("say class")
public class AnnotationDemo {

    @MyAnnotation(value = "say name")
    public String name;

    @MyAnnotation("say hello")
    public void hello() {
        System.out.println("say hello");
    }

    @MyAnnotation
    public void bye() {}
}
