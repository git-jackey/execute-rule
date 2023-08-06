package com.javayige.rules;


import com.javayige.context.EntityContextHolder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : orangeCy.奕
 * @Product : 猎豹养成产品源码
 * @Time : 2022/8/17
 * @Desc : 规则组定义明确
 */
public class RuleGroupDriver {
    public String getRuleGroupId() {
        return ruleGroupId;
    }

    public void setRuleGroupId(String ruleGroupId) {
        this.ruleGroupId = ruleGroupId;
    }

    public String getRuleGroupName() {
        return ruleGroupName;
    }

    public void setRuleGroupName(String ruleGroupName) {
        this.ruleGroupName = ruleGroupName;
    }

    public Boolean getParallelInvoke() {
        return parallelInvoke;
    }

    public void setParallelInvoke(Boolean parallelInvoke) {
        this.parallelInvoke = parallelInvoke;
    }

    public Set<AbstractRule> getRules() {
        return rules;
    }

    public void setRules(Set<AbstractRule> rules) {
        this.rules = rules;
    }

    private RuleGroupDriver() {
    }

    /**
     * 规则组ID
     */
    private String ruleGroupId;

    /**
     * 规则组name
     */
    private String ruleGroupName;

    /**
     * 是否并发处理
     */
    private Boolean parallelInvoke;
    /**
     * 规则集
     */
    private Set<AbstractRule> rules;

    public RuleGroupDriver bindingRule(AbstractRule rule) {
        if (Objects.isNull(rules)) {
            this.rules = new HashSet<>();
            rules.add(rule);
        } else {
            rules.add(rule);
        }
        return this;
    }

    /**
     * 实例化单线程处理规则组
     *
     * @param ruleGroupId
     * @param ruleGroupName
     */
    public static RuleGroupDriver instanceRuleDriver(String ruleGroupId, String ruleGroupName) {
        RuleGroupDriver ruleGroupDriver = new RuleGroupDriver();
        ruleGroupDriver.setRuleGroupId(ruleGroupId);
        ruleGroupDriver.setRuleGroupName(ruleGroupName);
        ruleGroupDriver.setParallelInvoke(Boolean.FALSE);
        return ruleGroupDriver;
    }

    /**
     * 实例化多线程处理规则组
     *
     * @param ruleGroupId
     * @param ruleGroupName
     */
    public static RuleGroupDriver instanceRuleDriverWithParallel(String ruleGroupId, String ruleGroupName) {
        RuleGroupDriver ruleGroupDriver = new RuleGroupDriver();
        ruleGroupDriver.setRuleGroupId(ruleGroupId);
        ruleGroupDriver.setRuleGroupName(ruleGroupName);
        ruleGroupDriver.setParallelInvoke(Boolean.TRUE);
        return ruleGroupDriver;
    }

    /**
     * 规则组处理
     */
    public void process() {
        if (parallelInvoke) {
            System.out.println("[规则组Id:" + ruleGroupId + "---> 规则组名称:" + ruleGroupName + "---> 接受到处理任务]");
            CountDownLatch begin = new CountDownLatch(1);
            CountDownLatch end = new CountDownLatch(rules.size());
            ExecutorService exec = Executors.newFixedThreadPool(rules.size());
            AbstractRule[] abstractRules = rules.toArray(new AbstractRule[0]);
            System.out.println("该规则组下共有" + abstractRules.length + "子规则");
            for (int index = 0; index < abstractRules.length; index++) {
                AbstractRule rule = abstractRules[index];
                System.out.println("该规则下共有" + rule.getHandlers().size() + "子处理器");
                Runnable run = () -> {
                    try {
                        begin.await();
                        if (rule.evaluateConditions(EntityContextHolder.getContext())) {
                            System.out.println("[规则Id:" + rule.getId() + "---> 规则名称:" + rule.getName() + "---> 被触发]");
                            rule.performActions();
                            System.out.println("[规则Id:" + rule.getId() + "---> 规则名称:" + rule.getName() + "---> 被成功执行]");
                        }
                    } catch (InterruptedException e) {
                        System.out.println("[规则Id:" + rule.getId() + "---> 规则名称:" + rule.getName() + "---> 执行异常]");
                    } finally {
                        end.countDown();
                    }
                };
                exec.submit(run);
            }
            System.out.println("[规则组Id:" + ruleGroupId + "---> 规则组名称:" + ruleGroupName + "---> 多线程开始处理]");
            begin.countDown();
            try {
                end.await();
            } catch (InterruptedException e) {
                System.out.println("[规则组Id:" + ruleGroupId + "---> 规则组名称:" + ruleGroupName + "---> 规则组执行过程中异常中断]");
            }
            System.out.println("[规则组Id:" + ruleGroupId + "---> 规则组名称" + ruleGroupName + "---> 多线程处理完成]");
            exec.shutdown();
        } else {
            System.out.println("[规则组Id:" + ruleGroupId + "---> 规则组名称:" + ruleGroupName + "---> 接受到处理任务]");
            System.out.println("[规则组Id:" + ruleGroupId + "---> 规则组名称:" + ruleGroupName + "---> 单线程开始处理]");
            System.out.println("该规则组下共有" + rules.size() + "子规则");
            for (AbstractRule rule : rules) {
                try {
                    System.out.println("该规则下共有" + rule.getHandlers().size() + "子处理器");
                    if (rule.evaluateConditions(EntityContextHolder.getContext())) {
                        System.out.println("[规则Id:" + rule.getId() + "---> 规则名称:" + rule.getName() + "---> 被触发]");
                        rule.performActions();
                        System.out.println("[规则Id:" + rule.getId() + "---> 规则名称:" + rule.getName() + "---> 被成功执行]");
                    }
                } catch (Exception ex) {
                    System.out.println("[规则Id:" + rule.getId() + "---> 规则名称:" + rule.getName() + "---> 执行异常]");
                }
            }
            System.out.println("[规则组Id:" + ruleGroupId + "---> 规则组名称:" + ruleGroupName + "---> 单线程处理完成]");
        }
    }
}
