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

