package com.iocContainer.domain;

/**
 * @ClassName: com.iocContainer.domain.User
 * @Author: liuzhuang10
 * @Date: 2021/5/7
 * @Describe:
 **/
public class User {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
