package com.iocContainer.dependency;

import com.iocContainer.repository.UserRespository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @ClassName: com.iocContainer.dependency.DependencyInjectionDemo
 * @Author: liuzhuang10
 * @Date: 2021/5/7
 * @Describe:  Spring IOC 依赖注入示例 Class
 **/
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //装配 XML 配置文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:META-INF/dependency-injection-context.xml");

        //依赖来源一：自定义Bean
        UserRespository userRespository = beanFactory.getBean("userRespository", UserRespository.class);
//        System.out.println(userRespository.getUsers());


        //依赖来源二： 依赖注入（内建依赖） DefaultListableBeanFactory
//        System.out.println(userRespository.getBeanFactory());
//        System.out.println(beanFactory);
//        System.out.println(userRespository.getBeanFactory() == beanFactory);

        ObjectFactory<ApplicationContext> objectFactory = userRespository.getObjectFactory();
        //ApplicationContext
        System.out.println(objectFactory.getObject());

        //内建对象
        System.out.println("内建Bean对象："+(objectFactory.getObject()== beanFactory));

        // 依赖来源三：容器内建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取Environment 类型的Bean: "+ environment);


    }

    private static void whoIsIocContainer(UserRespository userRepository,
                                          ApplicationContext applicationContext) {

        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory

        // ConfigurableApplicationContext#getBeanFactory()

        // 这个表达式为什么会不成立
        // 因为 AbstractRefreshableApplicationContext创建了DefaultListableBeanFactory，他们俩个并不是一个对象
        // false
        System.out.println("内建非 Bean 对象（依赖）: " + (userRepository.getBeanFactory() == applicationContext));

        // ApplicationContext is BeanFactory

    }


}
