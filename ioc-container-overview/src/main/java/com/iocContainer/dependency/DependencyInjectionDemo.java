package com.iocContainer.dependency;

import com.iocContainer.repository.UserRespository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        System.out.println(userRespository.getBeanFactory());
        System.out.println(beanFactory);
        System.out.println(userRespository.getBeanFactory() == beanFactory);


    }
}
