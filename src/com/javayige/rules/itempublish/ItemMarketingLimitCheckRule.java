package com.javayige.rules.itempublish;


import com.javayige.anotation.Rule;
import com.javayige.entity.LbItem;
import com.javayige.rules.AbstractRule;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 商品营销互斥校验规则
 */
@Rule(id = "itemMarketingLimitCheckRule", name = "商品发布规则", detail = "商品营销互斥校验规则")
public class ItemMarketingLimitCheckRule extends AbstractRule<LbItem> {

    @Override
    public boolean evaluateConditions(LbItem lbItem) {
        return false;
    }

    @Override
    public Rule getRuleAnnotation() {
        return ItemMarketingLimitCheckRule.class.getAnnotation(Rule.class);
    }

    @Override
    public ItemMarketingLimitCheckRule builder() {
        return (ItemMarketingLimitCheckRule) assembly(new ItemMarketingLimitCheckRule());
    }

    public static ItemMarketingLimitCheckRule build() {
        ItemMarketingLimitCheckRule checkRule = new ItemMarketingLimitCheckRule();
        return checkRule.builder();
    }
}
