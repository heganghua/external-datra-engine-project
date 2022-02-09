package com.jxzj.external.data.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// @Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "no description";
}
