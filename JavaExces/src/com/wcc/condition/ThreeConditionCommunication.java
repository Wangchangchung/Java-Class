package com.wcc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by charse on 17-10-1.
 */
public class ThreeConditionCommunication {


    public static void main(String[] args){
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0 ; i<= 10; i++){
                    business.sub2(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=10; i++){
                    business.sub3(i);
                }
            }
        }).start();

        for (int i = 0;i <= 10;i++){
            business.main(i);
        }
    }

    static  class Business{

        Lock lock =  new ReentrantLock();
        //使用三个Condition 对象, 主线程唤醒老二， 老二唤醒老三， 老三唤醒主线程
        Condition condition1 =  lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        private int shouldSub =1;

        public void sub2(int i ){

            lock.lock();
            try {
                while (shouldSub!=2){
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int n = 0;  n < 10;  n++ ){
                    System.out.println("sub1  thread sequence of " + n  + ", loop  of" + i);
                }
                shouldSub = 3;
                condition3.signal();
            }finally {
                lock.unlock();
            }

        }

        public void sub3(int i){
            lock.lock();
            try {
                while (shouldSub !=3){
                    try {
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int  n = 0; n < 20;n++){
                    System.out.println("sub2 thread sequence of " + n + ", loop of" + i);
                }
                shouldSub = 1;
                condition1.signal();
            }finally {
                lock.unlock();
            }
        }


        public void main(int i){
            lock.lock();
            try {
                while (shouldSub !=1){
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int n = 0 ; n < 5; n++){
                    System.out.println("main thread sequence of " + n  + ",loop of " + i);
                }

                shouldSub = 2;
                condition2.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}

