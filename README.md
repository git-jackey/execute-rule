# 🥤 注解抽象规则编排组件

> - 源码讲解视频+详细文档 : 加入Java奕哥知识星球。
> - 更多组件和录播讲解详见Java奕哥知识星球微信群。

## 组件概述

**使用场景一句话** ：

当面对复杂的业务进行开发时，程序本身逻辑代码和业务代码互相嵌套、错综复杂，代码一旦写死很难更改，而业务规则经常改变。这时候就需要使用规则编排来管理，这种业务模型的特性有着固定的输入参数和输出格式，中间规则部分要求能够配置化，尽可能灵活，不需要重新写代码。

**需要前置知识** ：

- 1.javase 注解、多态(熟悉)
- 2.threadlocal (熟悉)
- 3.java8语法(熟练)
- 4.泛型应用写法(熟练)
- 5.函数式接口定义(了解)

**你能收获什么** ：

- 1.学会利用自定义注解来实现代码解耦。
- 2.学会利用线程threadlocal上下文实践。
- 3.掌握复杂多规则业务代码中怎么利用这种解法管理。
- 4.提高编码能力，了解一线大厂代码的写法。
- 5.理解里面中间思想、设计、使用成为面试跳槽亮点。

**Java奕哥知识星球** ：
![](./src/xingqiu/img.png)

**tips:** ： 学会了这个组件包括思想，以后能在工作中大量使用，你会看到很多业务部门当业务复杂时候做执行编排，规则管理除了使用很重的开源框架之外，基本都会自实现一个轻量的组件来完成，因为这样零依赖无侵入。


