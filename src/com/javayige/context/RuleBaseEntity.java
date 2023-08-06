package com.javayige.context;


import java.io.Serializable;


/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 规则实体基类
 */
public class RuleBaseEntity implements Serializable {

    /**
     * 实体id
     */
    private Long entityId;

    public RuleBaseEntity(Long entityId) {
        this.entityId = entityId;
    }
}
