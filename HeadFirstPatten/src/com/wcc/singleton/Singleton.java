package com.wcc.singleton;

/**
 * Created by WCC on 2017/1/4.
 */
public class Singleton {

    private static  Singleton singleton;

    // 构造器声明为私有的
    private Singleton(){};

    // 通过getInstance 获取实例。  方法是静态的
    // 这意味它是一个类的方法，所以可以在代码的任何地方
    //使用Singletion.getInstance()访问他a

    // 还有一个优点是： 单例可以延迟实例化
    public static  Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return  singleton;
    }

    //但是上面的代码在遇到多线程的时候还是会出现问题的
    // 可能 会实例化出多个 Singleton 对象的。
    /**
     * 那么如何解决多线程的问题呢？
     *
     * 1、对getInstance()方法进行同步， 同步之后就可以解决多线程执行时出现多个实例的问题
     *     缺陷：同步方法将会导致程序的执行效率降低 100 倍，因此当在频繁使用getInstance()
     *          的程序中, 要慎重的考虑这中情况
     * 2、使用 “急切” 创建实例，而不是用延迟实例化的做法。
     *     private static Singleton singleton = newe Singleton();
     *     这样JVM加载这个类的时候这个列立马创建唯一的单例实例，
     *     保证了在任何线层访问之前已经有一个实例了。
     * 3、用 “双重检查加锁”，在getInstance() 中减少使用同步
            利用双重检查加锁，首先检查是否实例已经创建了，如果尚未创建，才
            进行同步，这样一来，只有第一次会同步

            private volatile static Singleton singleton;
            private Singleton(){}
            public static Singleton getInstance(){
                if(singleton == null){
                    synchronized(Singleton.class){
                        if(Singleton == null){
                            singleton = new Singleton();
                        }
                    }
                }
            }
     *
     * 使用这个方法的条件是 jdk 必须是1.5 (Java 5)及其以上的版本
     * 在更早的版本中JVM对于volatile关键字的实现会导致双重检查加锁的失效
     *
     *
     *
     *
     */

}
