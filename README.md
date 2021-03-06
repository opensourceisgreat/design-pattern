# design-pattern

设计模式案例

## 案例一: 通过代理模式整合mybatis和spring

参考文档：

[https://blog.csdn.net/sinat_42483341/article/details/105643583](https://blog.csdn.net/sinat_42483341/article/details/105643583)

[太好了！总算有人把动态代理、CGlib、AOP都说清楚了](https://cloud.tencent.com/developer/article/1461796)

必要说明：FactoryBean的作用以及BeanDefinitionRegistryPostProcessor的作用

[Spring中老生常谈的FactoryBean](https://www.cnblogs.com/yulinfeng/p/11456587.html)

[spring中的BeanDefinitionRegistryPostProcessor](https://www.cnblogs.com/tdyang/p/12088554.html)

FactoryBean 类型的 bean 放入到容器中，生成对应的 BeanDefinition ，通过它的 beanName 会返回该实例中的方法 getObject 所返回的实例，如果你需要返回 FactoryBean 实例本身，需要在 beanName 的名称前加入“&”。FactoryBean 帮助我们将代理类返回给 spring 容器，而创建代理类的过程实际上是 mybatis 已经完成了，中间件将其拿过来返回即可。本案例直接在 FactoryBean 中模拟生成了代理类。

BeanDefinitionRegistryPostProcessor 类放入到容器中会放入到 BeanDefinitionMap 中，然后 spring 会将该类型的类中的 postProcessBeanDefinitionRegistry 方法执行，生成自定义的 BeanDefinition ，自定义的 BeanDefinition 在 beanName 和配置文件中 beanName 相同时前者会覆盖后者，本案例中可以发现定义了两个 userDao 的 beanName。

本案例中 BeanDefinitionRegistryPostProcessor(RegisterBeanFactory) 会将 FactoryBean(MapperFactoryBean) 包装成 BeanDefinition 放置到 BeanDefinitionMap 中，并且覆盖了原来的 RegisterBeanFactory 的BeanDefinition，因为这两个实例 beanName 相同。容器中无法再获取 RegisterBeanFactory 的BeanDefinition。

spring 注册 bean 的流程：spring 注册配置文件中的 bean 到 BeanDefinitionMap 中，然后执行 BeanDefinitionMap 中该(BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor)类型中的处理器(Bean 工厂后置处理器)，然后通过 BeanDefinitionMap 中的 BeanDefinition 实例化 bean 对象，然后属性赋值，初始化，销毁。

## 案例二: 工厂设计模式 

模拟奖品发放

## 案例三: 抽象工厂设计模式

本案例中实现的是这样一种情况：业务初期使用的是 Redis 单机服务，使用的接口是 CacheService ,实现类是 CacheServiceImpl，需要做的是拓展 Redis 集群服务(IIR,EGM)后，不改变原来的业务调用接口，完成调用新来的集群服务。

## 案例四: 建造者模式

多个简单对象通过一步步组装构建成一个复杂对象的过程。本案例模拟情况：给定装修材料，通过组合材料得到不同的装修等级。

## 案例五: 原型模式

用于创建重复对象，这部分对象本身复杂。给每个用户提供相同试卷，但是又不便于每次从库中或远程 RPC ，本案例实现 Cloneable 接口，完成对象克隆

## 案例六: 单例模式

静态内部类模式和 DCL 模式，值得推荐使用

## 案例七: 适配器模式

模拟三种不同的 MQ 消息，以及两个接口，对不同的消息和接口进行统一化处理适配。涉及对接口适配和消息适配的两种适配

## 案例八: 桥接模式

本案例是多支付（支付宝、微信等）和多模式（指纹、人脸等）进行桥接。

## 案例九: 装饰器模式

模拟扩展 SSO 功能，原始 SSO 只具备账户是否合法，现在扩展鉴权功能

## 案例十: 责任链模式

模拟618大促期间的业务系统上线审批流程场景，在特定时间增加不同的流程。

## 案例十一: 观察者模式

模拟摇号后，将结果通知给用户

## 案例十二: 策略模式

## 案例十三: 组合模式