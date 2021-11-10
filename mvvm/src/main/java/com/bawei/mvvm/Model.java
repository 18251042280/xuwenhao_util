package com.bawei.mvvm;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Android Studio.
 * User: 小徐
 * Date: 2021/11/9
 * Time: 18:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Model {
    String value() default "";
}