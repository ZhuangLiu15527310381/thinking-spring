package com.iocContainer.repository;

import com.iocContainer.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @ClassName: com.iocContainer.repository.UserRespository
 * @Author: liuzhuang10
 * @Date: 2021/5/7
 * @Describe: 用户信息仓库
 **/
public class UserRespository {

    /**
     * 自定义bean
     */
    private Collection<User> users;

    /**
     * 内建非Bean对象（依赖）
     */
    private BeanFactory beanFactory;

    /**
     * 内建Bean对象
     */
    private ObjectFactory<ApplicationContext> objectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
