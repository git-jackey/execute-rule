package com.javayige.handlers;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 处理器泛型
 */
public interface IHandler<T> {

    /**
     * 处理事件Event
     *
     * @param t
     */
    void onEvent(T t);
}
