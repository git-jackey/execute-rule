package com.javayige.start;


import com.javayige.rules.RuleGroupDriver;

import java.util.List;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 规则处理引擎
 */
public class RuleProcessEngine {

    /**
     * 启动
     *
     * @param ruleGroups
     */
    public static void start(List<RuleGroupDriver> ruleGroups) {
        ruleGroups.forEach(RuleProcessEngine::start);
    }

    /**
     * 启动
     *
     * @param ruleGroup
     */
    public static void start(RuleGroupDriver ruleGroup) {
        ruleGroup.process();
    }
}
