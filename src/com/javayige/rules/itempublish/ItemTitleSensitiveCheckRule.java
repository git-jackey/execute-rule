package com.javayige.rules.itempublish;


import com.javayige.anotation.Rule;
import com.javayige.entity.LbItem;
import com.javayige.rules.AbstractRule;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 商品标题敏感词校验规则
 */
@Rule(id = "itemTitleSensitiveCheckRule", name = "商品发布规则", detail = "商品标题敏感词校验规则")
public class ItemTitleSensitiveCheckRule extends AbstractRule<LbItem> {

    @Override
    public boolean evaluateConditions(LbItem lbItem) {
        return true;
    }


    @Override
    public Rule getRuleAnnotation() {
        return ItemTitleSensitiveCheckRule.class.getAnnotation(Rule.class);
    }

    @Override
    public ItemTitleSensitiveCheckRule builder() {
        return (ItemTitleSensitiveCheckRule) assembly(new ItemTitleSensitiveCheckRule());
    }

    public static ItemTitleSensitiveCheckRule build() {
        ItemTitleSensitiveCheckRule checkRule = new ItemTitleSensitiveCheckRule();
        return checkRule.builder();
    }
}
