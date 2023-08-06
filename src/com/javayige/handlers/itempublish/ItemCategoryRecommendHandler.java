package com.javayige.handlers.itempublish;


import com.javayige.context.RuleBaseEntity;
import com.javayige.handlers.IHandler;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/18
 * @Desc : 商品类目处理器
 */
public class ItemCategoryRecommendHandler implements IHandler<RuleBaseEntity> {

    @Override
    public void onEvent(RuleBaseEntity order) {
        //do your biz logic 做你的业务逻辑
        System.out.println("检查商品类目推荐匹配");
    }
}
