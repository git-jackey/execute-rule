package com.javayige.rules;


import com.javayige.anotation.Rule;
import com.javayige.context.EntityContextHolder;
import com.javayige.context.RuleBaseEntity;
import com.javayige.handlers.IHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 抽象规则规范
 */
public abstract class AbstractRule<T> {
    /**
     * 规则Id
     */
    private String id;
    /**
     * 规则名称
     */
    private String name;
    /**
     * 规则处理器
     */
    private List<IHandler<RuleBaseEntity>> handlers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IHandler<RuleBaseEntity>> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<IHandler<RuleBaseEntity>> handlers) {
        this.handlers = handlers;
    }

    /**
     * 满足的触发条件
     *
     * @param t
     * @return
     */
    public abstract boolean evaluateConditions(T t);

    public AbstractRule<T> assembly(AbstractRule<T> aRule) {
        Rule annotation = getRuleAnnotation();
        aRule.setId(annotation.id());
        aRule.setName(annotation.name());
        return aRule;
    }

    public AbstractRule<T> addHandler(IHandler<RuleBaseEntity> iHandler) {
        if (Objects.isNull(handlers)) {
            handlers = new ArrayList<>();
            handlers.add(iHandler);
        } else {
            handlers.add(iHandler);
        }
        return this;
    }

    /**
     * 获取规则注解
     *
     * @return
     */
    public abstract Rule getRuleAnnotation();

    public abstract AbstractRule<T> builder();

    /**
     * 规则处理器handler处理事件
     */
    public void performActions() {
        for (IHandler<RuleBaseEntity> handler : handlers) {
            handler.onEvent(EntityContextHolder.getContext());
        }
    }
}
