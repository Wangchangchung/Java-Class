package com.wcc.thread;

import java.util.Random;

/**
 * Created by charse on 17-8-27.
 */
public class TheradLocalObject {



    public   static  ThreadLocal<Integer>   threadLocal = new ThreadLocal<>();

    public  static  ThreadLocal<MyThreadLocalObject>  objetcThreadLocal = new ThreadLocal<>();


    public static  void main(String[] args){

        for (int i = 0; i < 2; i++){

            new Thread(new Runnable() {
                @Override
                public void run() {

                    int data = new Random().nextInt();

                    threadLocal.set(data);

                    //　如果要存储对各数据呢？　那么需要创建　多个TheadLocal对象来码？　

                    //　当然不是这样的的
                    /*
                    MyThreadLocalObject myObject = new MyThreadLocalObject();
                    myObject.setAge(10);
                    myObject.setName("hello");
                    objetcThreadLocal.set(myObject);
                    */
                    ///此时就不用这样的去获了
                    //　存数据　　此时的　getThreadInstance()　拿到的就是本线称相关的　如果已近存在这个对象就
                    //　使用, 如果不存在, 就创建, 与类线程相关的类实例
                     MyThreadLocalObject.getThreadInstance().setName("name:" + data);
                     MyThreadLocalObject.getThreadInstance().setAge(data);
                      //我们这样设计的化　TheadLocal　这变量就隐藏在我们这个类中了　
                      //这个类中暴露的只是一个静态方法，就可以得到与但前线程相关的实例对象
                      //里面是如何处理的，对外是完全不知道的 . 我们是把TreadLocal放在这个类的内部，这样设计就比较合理
                    new A().get();
                    new B().get();

                }
            }).start();


        }

    }


    static class A{
        public void get(){
            int data = threadLocal.get();
            System.out.println("A from " + Thread.currentThread().getName() + " get data :" + data);

            //MyThreadLocalObject myObject  = objetcThreadLocal.get();
            //得到本线程
            MyThreadLocalObject myObject = MyThreadLocalObject.getThreadInstance();

            System.out.println("A from " + Thread.currentThread().getName() + " get data name :"  + myObject.getName() +
            " age :" + myObject.getAge() );
        }
    }

    static class B{
        public void get(){
            int data = threadLocal.get();
            System.out.println("B from " + Thread.currentThread().getName() + " get data :" + data);

            //MyThreadLocalObject myObject  = objetcThreadLocal.get();
            //得到本线程
            MyThreadLocalObject myObject = MyThreadLocalObject.getThreadInstance();

            System.out.println("B　 from " + Thread.currentThread().getName() + " get data name :"  + myObject.getName() +
                    " age :" + myObject.getAge() );
        }
    }



}

class MyThreadLocalObject {


    private String name;

    private int age;

    private MyThreadLocalObject(){}

    //调用静态方法
    public static MyThreadLocalObject getThreadInstance(){

        MyThreadLocalObject instance = threadLocal.get();
        if (instance == null){
            instance = new MyThreadLocalObject();
            threadLocal.set(instance);;
        }
        return instance;
    }

    private static ThreadLocal<MyThreadLocalObject> threadLocal = new ThreadLocal<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}

