package com.wcc.thread;

import com.wcc.lock.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by charse on 17-5-13.
 */
public class CASLockDemo {

    private AtomicInteger atomicI = new AtomicInteger(0);
    private  int i = 0;

    public  static void main(String[] ags){
        final Counter cas  = new Counter();
        List<Thread>  threads = new ArrayList<Thread>(600);

        long start = System.currentTimeMillis();
        for (int j = 0;  j < 100; j++){
            Thread t  = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000;i ++){
                      //  cas.count();
                        //cas.s
                    }
                }
            });
        }
    }
}
