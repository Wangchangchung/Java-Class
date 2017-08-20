package com.wcc.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by wcc on 31/03/17.
 *
 * Callable 接口类似与Runnable,从名字上就可以看出来，但是Runnable
 * 不会返回结果，并且无法抛出返回结果的异常，而Callable 功能更加强大一些，被线程执行后，可以
 * 返回值，这个返回值可以被Future拿到，也就是说，Future可以拿到异步执行任务的
 * 返回值。
 *
 */
public class Future {

    public  static  void main(String[] args){
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

        new Thread(futureTask).start();

        try {
            Thread.sleep(5000);
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/*
    FutureTask 实现了两个接口，Runnable 和 Future,所以它既可以作为
    Runnable被线程执行，又可以作为Future得到Callable 的返回值，
    那么就可以使用这个组合，用另一个线程去计算返回值，而当前线程在使用这个返回值之前可以做
    其他的操作，等到需要这个返回值的时候，再通过Future得到。

 */
