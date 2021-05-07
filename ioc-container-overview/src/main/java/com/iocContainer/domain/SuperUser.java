package com.iocContainer.domain;

import com.iocContainer.annotaion.Super;

/**
 * @ClassName: com.iocContainer.domain.SuperUser
 * @Author: liuzhuang10
 * @Date: 2021/5/7
 * @Describe:
 **/
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                '}'+ super.toString();
    }
}
