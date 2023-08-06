package com.javayige.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 规则注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Rule {
    /**
     * 规则id
     *
     * @return
     */
    String id();

    /**
     * 规则name
     *
     * @return
     */
    String name();

    /**
     * 规则描述
     *
     * @return
     */
    String detail();
}
