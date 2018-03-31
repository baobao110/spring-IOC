package com.java;

import com.java.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public void testUser(){
        //加载spring配置对象 创建对象，其实就是解析xml文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //得到配置对象，创建对象，其实这里的context就是工厂类,getBean就是通过工厂模型获取对象，工厂模型内部应该是使用反射
        User user=(User)context.getBean("User");
        System.out.println(user);
        user.add();
    }

    public static void main(String []args){
        test a=new test();
        a.testUser();
    }
}
/**
 * spring IOC底层原理使用技术：
 *1 xml配置文件
 * 2 dom4j解析xml
 * 3 工厂设计模型
 * 4 反射
 *
 * ioc原理：
 * 1 创建xml配置文件
 * 2 2 创建工厂类ApplicationContext Bean(配置文件的对象id)，
 * 用dom4j解析配置文件，指的是这里的ClassPathXmlApplicationContext，
 * 后面通过反射获取对象其实就是getBean（）方法的内容，大概是下面，实际源码要复杂的多
 * public static Object getBean(String value){
 *     Class clazz=Class.forName(value);
 *     return clazz.newInstance();
 * }
 */


