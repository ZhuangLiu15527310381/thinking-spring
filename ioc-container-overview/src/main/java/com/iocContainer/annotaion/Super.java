package com.iocContainer.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: com.iocContainer.annotaion.Super
 * @Author: liuzhuang10
 * @Date: 2021/5/7
 * @Describe: 超级 annotation
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
