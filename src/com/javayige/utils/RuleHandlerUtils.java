package com.javayige.utils;


import com.javayige.anotation.Rule;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/19
 * @Desc : 规则处理器工具 可应用于生产环境配置
 */
public class RuleHandlerUtils {

    private RuleHandlerUtils() {
    }

    /**
     * 规则包 可做成配置
     */
    private static final String rulePackage = "com.orangecy.executerule.rules.*";

    /**
     * 获取规则
     *
     * @return
     */
    public static List<Rule> getRules() {
        List<Rule> rules = new ArrayList<Rule>();
        Reflections reflections = new Reflections(rulePackage);
        Set<Class<?>> allClasses = reflections
                .getTypesAnnotatedWith(Rule.class);
        for (Class<?> glass : allClasses) {
            Rule rule = glass.getAnnotation(Rule.class);
            rules.add(rule);
        }
        return rules;
    }
}
