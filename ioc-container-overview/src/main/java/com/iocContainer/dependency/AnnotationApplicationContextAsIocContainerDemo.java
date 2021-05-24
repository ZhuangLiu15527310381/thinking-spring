package com.iocContainer.dependency;

import com.iocContainer.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @ClassName: com.iocContainer.dependency.AnnotationApplicationContextAsIocContainerDemo
 * @Author: liuzhuang10
 * @Date: 2021/5/24
 * @Describe:
 **/
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {
    public static void main(String[] args) {
        //创建 Spring 上下文容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //将当前类 AnnotationApplicationContextAsIocContainerDemo 作为配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);

        //初始化上下文
        applicationContext.refresh();

        lookupCollectionByType(applicationContext);

    }
    /**
     * Bean 定义
     * @return
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId("sad");
        user.setName("川普");
        return user;
    }
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有到User 集合对象：" + beans);
        }
    }
}
