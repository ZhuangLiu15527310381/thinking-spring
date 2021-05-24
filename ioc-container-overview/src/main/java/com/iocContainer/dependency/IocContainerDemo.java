package com.iocContainer.dependency;

import com.iocContainer.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @ClassName: com.iocContainer.dependency.IocContainerDemo
 * @Author: liuzhuang10
 * @Date: 2021/5/24
 * @Describe: Xml 配置能力 SpringIoc 容器Class
 **/
public class IocContainerDemo {

    public static void main(String[] args) {
        //创建BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建Xml配置读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        //Xml 配置文件ClassPath 路径
        String location = "classpath:META-INF/dependency-lookup-context.xml";

        //加载配置
        int beanDefinitionCount = reader.loadBeanDefinitions(location);

        System.out.println("Bean 定义加载的数量："+beanDefinitionCount);

        lookupCollectionByType(beanFactory);


    }

    private static void lookupCollectionByType(DefaultListableBeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory =(ListableBeanFactory) beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查到的所有的User 集合对象："+beans);
        }

    }
}
