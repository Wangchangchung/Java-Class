package com.wcc.threadpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by charse on 17-5-8.
 */
public class PoolThread  extends  Thread{

    private BlockingDeque<Runnable>  taskQueue = null;
    private boolean isStopped  = false;

    public PoolThread(BlockingQueue queue){
       // this.taskQueue = queue;
    }

    public void  run(){
        while (!isStopped()){
            Runnable runnable = null;
            try {
                runnable = taskQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
                // 写日志或着报告异常
                // 但是保持线程池运行
            }

        }
    }

    public  synchronized  void toStop(){
        isStopped  =true;
        this.interrupt();// 打断线程池中的 dequeue() 调用
    }

    public  synchronized boolean isStopped(){
        return  isStopped;
    }
}
