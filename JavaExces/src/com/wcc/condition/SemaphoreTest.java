package com.wcc.condition;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by charse on 17-10-1.
 */
public class SemaphoreTest {


    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "已经进入, 当前已经有" + (3-semaphore.availablePermits()));
                    try {
                        Thread.sleep((long) (Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                    System.out.println("当前已经有" + (3-semaphore.availablePermits()));

                }
            };
            service.execute(runnable);
        }

    }
}
