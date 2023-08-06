package com.javayige.test;


import com.javayige.handlers.itempublish.ItemCategoryRecommendHandler;
import com.javayige.handlers.itempublish.ItemOtherMoreInfoHandler;
import com.javayige.handlers.itempublish.ItemTitleSensitiveRiskHandler;
import com.javayige.rules.RuleGroupDriver;
import com.javayige.rules.itempublish.ItemTitleSensitiveCheckRule;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 测试规则执行
 */
public class Client {

    public static void main(String[] args) {
        // 单个规则组测试
        singleRuleGroupTest();

        // 给粉丝留下的作业
        multiRuleGroupTest();
    }

    private static void multiRuleGroupTest() {
        // 快来try try coding
    }

    private static void singleRuleGroupTest() {
        String ruleGroupId = "1";
        String ruleGroupName = "商品发布规则组";
        RuleGroupDriver ruleGroupDriver = RuleGroupDriver.instanceRuleDriver(ruleGroupId, ruleGroupName);
        ItemTitleSensitiveCheckRule rule1 = ItemTitleSensitiveCheckRule.build();
        rule1.addHandler(new ItemTitleSensitiveRiskHandler())
                .addHandler(new ItemCategoryRecommendHandler())
                .addHandler(new ItemOtherMoreInfoHandler());

        //如法炮制 etc..
        //ItemStockNumQuotaCheckRule rule2 = ItemStockNumQuotaCheckRule.build();
        ruleGroupDriver.bindingRule(rule1);
        ruleGroupDriver.process();
    }
}
