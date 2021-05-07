package com.iocContainer.dependency;

import com.iocContainer.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: com.iocContainer.dependency.DependencyLookUpDemo
 * @Author: liuzhuang10
 * @Date: 2021/5/7
 * @Describe:
 **/
public class DependencyLookUpDemo {

    public static void main(String[] args) {
        //装配 XML 配置文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:META-INF/dependency-lookup-context.xml");
        //按名称查找bean
        //实时装配
        lookupInRealTime(beanFactory);
        //懒加载模式
        lookupInLazy(beanFactory);

        //按照类型进行查找
//        lookupByType(beanFactory);

        //按名称+类型方式查找
        lookupByTypeAndName(beanFactory);




    }

    private static void lookupByTypeAndName(BeanFactory beanFactory) {
        User user2 = beanFactory.getBean("user2", User.class);

        System.out.println("按照类型和名称进行查找："+user2);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User bean = beanFactory.getBean(User.class);
        System.out.println("按类型实时查找："+bean);
    }

    /**
     * Bean 名称延时查找
     * @param beanFactory
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory =(ObjectFactory<User>) beanFactory.getBean("objectFactory");

        User user = objectFactory.getObject();
        System.out.println("延迟查找："+user);
    }

    /** Bean 实时查找
     * @param beanFactory bean工厂
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");

        System.out.println("实时查找："+user);

    }


}
