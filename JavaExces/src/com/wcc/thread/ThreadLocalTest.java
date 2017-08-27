package com.wcc.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by charse on 17-8-27.
 *
 * 实现　 TheadLocal　　
 *
 * 使用Map结构
 */


public class ThreadLocalTest {

    private static Map<Thread, Integer> theadData = new HashMap<Thread, Integer>();

    public static void main(String[] args){
        for (int i = 0; i < 2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data  = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()  + "　has put data :" + data);
                    theadData.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        public void get(){
            int data = theadData.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName() + "get data :" + data);
        }
    }

    static class B{
        public void get(){
            int data = theadData.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName() + "get data :" + data);
        }
    }
}

