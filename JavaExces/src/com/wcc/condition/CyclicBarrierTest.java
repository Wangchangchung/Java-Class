package com.wcc.condition;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by charse on 17-10-1.
 */
public class CyclicBarrierTest {

    public static void main(String[] args){
        ExecutorService service  = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i=0;i < 3; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println("sss" + Thread.currentThread().getName());

                        cyclicBarrier.await();

                        Thread.sleep((long) (Math.random()*1000));

                        System.out.println("ddd" +  Thread.currentThread().getName());

                        cyclicBarrier.await();

                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println("fff" +  Thread.currentThread().getName());
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            service.execute(runnable);
        }
        service.shutdown();
    }
}
