package com.dgz.springboot15.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface QueryCachePage {

     String key();

     Class<?> clazz();
}
