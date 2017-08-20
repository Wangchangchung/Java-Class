package com.wcc.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by charse on 17-4-6.
 */
public class MehtodInterceptor implements MethodInterceptor {

    /**
     *  定义方法拦截器
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before:" + method);
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("After:" + method);
        return object;
    }
}
