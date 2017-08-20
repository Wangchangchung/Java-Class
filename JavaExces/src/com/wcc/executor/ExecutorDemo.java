package com.wcc.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/**
 * Created by wcc on 19/03/17.
 */
public class ExecutorDemo {
    private  static Executor executor =  Executors.newFixedThreadPool(10);

    public  static  void  main(String[] args){
        for (int i = 0; i < 20; ++i){
            executor.execute(new Task());
        }
    }

    static  class  Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
