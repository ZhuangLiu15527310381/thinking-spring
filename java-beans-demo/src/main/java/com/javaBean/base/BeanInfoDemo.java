package com.javaBean.base;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @ClassName: com.javaBean.base.BeanInfoDemo
 * @Author: liuzhuang10
 * @Date: 2021/5/7
 * @Describe:
 **/
public class BeanInfoDemo {


    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor->{
            //propertyDescriptor 允许添加属性编辑器 PropertyEditor
            //GUI -> text(String) -> PropertyType
            // name -> String
            // age -> Integer
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyTypeName = propertyType.getName();
            //为age  字段/属性增加 PropertyEditor
            if ("age".equals(propertyTypeName)){
                // 将String 转换成 Integer
                Integer age = Integer.valueOf("99");
                propertyDescriptor.setPropertyEditorClass(StringToIntergerPropertyEditor.class);
            }

            System.out.println(propertyType);
        });

        System.out.println(beanInfo);

    }


    private static class StringToIntergerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
