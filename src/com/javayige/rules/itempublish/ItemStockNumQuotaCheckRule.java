package com.javayige.rules.itempublish;


import com.javayige.anotation.Rule;
import com.javayige.entity.LbItem;
import com.javayige.rules.AbstractRule;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 商品库存限购校验规则
 */
@Rule(id = "itemStockNumQuotaCheckRule", name = "商品发布规则", detail = "商品库存限购校验规则")
public class ItemStockNumQuotaCheckRule extends AbstractRule<LbItem> {

    @Override
    public boolean evaluateConditions(LbItem lbItem) {
        return true;
    }

    @Override
    public Rule getRuleAnnotation() {
        return ItemStockNumQuotaCheckRule.class.getAnnotation(Rule.class);
    }

    @Override
    public ItemStockNumQuotaCheckRule builder() {
        return (ItemStockNumQuotaCheckRule) assembly(new ItemStockNumQuotaCheckRule());
    }

    public static ItemStockNumQuotaCheckRule build() {
        ItemStockNumQuotaCheckRule checkRule = new ItemStockNumQuotaCheckRule();
        return checkRule.builder();
    }
}
