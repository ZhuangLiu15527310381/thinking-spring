package com.javaBean.base;

/**
 * @ClassName: com.javaBean.base.Person
 * @Author: liuzhuang10
 * @Date: 2021/5/7
 * @Describe:   POJO 认为是：Setter/Getter 方法
 *
 * Java Beans 认为是：可写方法（Writable）/可读方法（Readable）
 **/
public class Person {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
