package com.javayige.handlers.itempublish;


import com.javayige.context.RuleBaseEntity;
import com.javayige.handlers.IHandler;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/18
 * @Desc : 商品标题处理器
 */
public class ItemTitleSensitiveRiskHandler implements IHandler<RuleBaseEntity> {

    @Override
    public void onEvent(RuleBaseEntity t) {
        //do your biz logic 做你的业务逻辑
        System.out.println("风控检查商品标题是否含有敏感词");
    }
}
