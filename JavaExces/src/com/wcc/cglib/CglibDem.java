package com.wcc.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by charse on 17-4-5.
 */
public class CglibDem {


    public static  void  main(String[] arhs){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MehtodInterceptor());
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.add();
    }
    /**
     * 代理对象的生成过程由Enhancer类实现， 大概的步骤如下：
     * 1、生成代理类Class 的二进制字节码
     * 2、通过Class.forName 加载二进制字节码，生成Class 对象
     * 3、通过反射机制获取实例构造，并初始化代理类对象 。
     * Enhancer 是 cglib 的字节码增强器，可以方便的对类进行扩展
     * 内部调用 GeneratorStrategy.generate 方法生成代理类的字节码，
     *
     * JDK  和 cglib 动态代理实现的区别
     * 1、jdk 动态代理生成的代理类和委托类实现了相同的接口
     * 2、cglib 动态代理中生成的字节码更加复杂，生成的代理类是委托类的
     * 子类，且不能处理被final 关键字修饰的方法
     * 3、jdk 采用反射机制调用委托类的方法.  cglib采用类似索引的方式
     * 直接调用委托类方法。
     *
     */

}
