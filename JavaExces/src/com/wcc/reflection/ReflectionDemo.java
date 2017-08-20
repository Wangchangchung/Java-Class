package com.wcc.reflection;

import sun.reflect.ReflectionFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wcc on 18/03/17.
 */
public class ReflectionDemo {
    public static  void main(String[] args){

        try {

            ProxyDemo proxy = new ProxyDemo();
            Method method = ProxyDemo.class.getDeclaredMethod("run");
            method.invoke(proxy);
            Class c ;
            ReflectionFactory f;


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    static class ProxyDemo{
        public void  run(){
            System.out.println("使用反射调用run");
        }
    }
}
