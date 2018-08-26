今天写mysql数据库主从读写分离时，需要根据datasource的配置信息，获取到从库的数量，来实现从库轮询策略访问，在看spring中的AbstractRoutingDataSource源码时，看到afterPropertiesSet方法，然后在网上看到了这篇博客，写的很详细。

-------------------------------------------------------

一、简单介绍
1、init-method方法，初始化bean的时候执行，可以针对某个具体的bean进行配置。init-method需要在applicationContext.xml配置文档中bean的定义里头写明。例如：<bean id="TestBean" class="nju.software.xkxt.util.TestBean" init-method="init"></bean>
这样，当TestBean在初始化的时候会执行TestBean中定义的init方法。

2、afterPropertiesSet方法，初始化bean的时候执行，可以针对某个具体的bean进行配置。afterPropertiesSet 必须实现 InitializingBean接口。实现 InitializingBean接口必须实现afterPropertiesSet方法。

3、BeanPostProcessor，针对所有Spring上下文中所有的bean，可以在配置文档applicationContext.xml中配置一个BeanPostProcessor，然后对所有的bean进行一个初始化之前和之后的代理。BeanPostProcessor接口中有两个方法： postProcessBeforeInitialization和postProcessAfterInitialization。 postProcessBeforeInitialization方法在bean初始化之前执行， postProcessAfterInitialization方法在bean初始化之后执行。

总之，afterPropertiesSet 和init-method之间的执行顺序是afterPropertiesSet 先执行，init-method 后执行。从BeanPostProcessor的作用，可以看出最先执行的是postProcessBeforeInitialization，然后是afterPropertiesSet，然后是init-method，然后是postProcessAfterInitialization。

二、相关用法及代码测试
1、PostProcessor类，实现BeanPostProcessor接口，实现接口中的postProcessBeforeInitialization，postProcessAfterInitialization方法
[java] view plaincopy
package nju.software.xkxt.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 定义Bean初始化前后的动作
 *
 * @author typ
 *
 */
public class PostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("------------------------------");
        System.out.println("对象" + beanName + "开始实例化");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("对象" + beanName + "实例化完成");
        System.out.println("------------------------------");
        return bean;
    }

}

该PostProcessor类要作为bean定义到applicationContext.xml中，如下
<bean class="nju.software.xkxt.util.PostProcessor"></bean>

2、TestBean类，用做测试Bean，观察该Bean初始化过程中上面4个方法执行的先后顺序和内容。实现InitializingBean接口，并且实现接口中的afterPropertiesSet方法。最后定义作为init-method的init方法。