package com.wcc.thread;

/**
 * Created by charse on 17-8-26.
 */
public class ThreadLock {

    public  static  void  main(String[] args){

        Business business  = new Business();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 50; ++i){

                            business.subDo(10);
                }
            }
        });


        thread.start();

        for (int i = 0; i < 50; ++i){
            business.mainDo(100);
        }

    }


}


class Business{


    public  boolean isSubShouldDo = true;



    public  synchronized void subDo(int n){

        while (!isSubShouldDo){

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for (int i = 0 ; i < n; ++i ){
            System.out.println("sub do :" + i);
        }
        isSubShouldDo = false;
        this.notify();
    }


    public synchronized  void mainDo(int n){

        /*

        我们这里是可以是使用if　做判断,　但是我们还是
        使用　while, 使用while是可以进行下一步的检查，这个
        主要的问题是　防止　假醒的问题出现，因为可能不是子线程唤醒主线程的
        所以我们这里就直接进行　再次的判断，到底是不是自己该执行了


        而且我们在设计的时候，　对于线程竞争之类的资源，应该放在同一个类中
        而不应该放在线程的代码中，　
        第一， 对于业务处理类来说，内部的状态是不需要外部管的
        第二，　这个业务类中的各个方法已经处理好了线程安全的问题了，如果还有线程
        那么直接使用就行了，而不用再在线程指针之中进行线程安全的处理．

        <张孝祥的多线程的视频教程　　线程同步这节>

        if (isSubShouldDo){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        */


        while (isSubShouldDo){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0;  i < n; ++i){
            System.out.println("main do:" + i);
        }
        isSubShouldDo = true;
        this.notify();
    }

}
