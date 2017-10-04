package com.wcc.condition;

import com.wcc.thread.TheadStart;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by charse on 17-10-2.
 * CountDownLatch 是一个同步工具类，它允许一个或多个线程一直等待
 * 直到其他线程的操作执行完成之后再执行, 在Java并发中
 * countdownlatch 的概念是一个常见的面试题 一定要很好的理解它
 *
 *
 * 使用场景
 * 应用程序的主线程希望在负责启动框架服务的
 * 线程已经启动所有的框架之后再执行
 *
 * CountDownLath是通过一个计数器来实现的，计数器的初始值为线程的数量
 * 每当一个线程完成了自己的任务后，计数器的值就会减1，当计数器值到达0时，它表示所有的线程已经完成了任务，然后在
 * 闭锁上等待的线程就可以恢复执行任务
 *
 *public CountDownLatch(int count){
 *
 *}
 * 构造器中的技术值 实际上就是闭锁需要等待的线程数量。 这个值只能被设置一次
 * 而且CountDownLatch 没有提供任何机制去重新设置这个计数值
 *
 * 在实时系统中的使用场景
 * 1. 实现最大的并行性： 有时我们想同时启动多个线程，实现最大程度的并行性，例如:
 * 我们想测试一个单例类。如果我们创建一个初始数为1的CountDownLatch, 并让所有线程都在
 * 这个锁上等待，那么我们可以很轻松的完成测试。我们只需要调用一次countDown()方法可以让
 * 所有的线程等待同时恢复执行
 *
 *2. 开始执行前等待n个线程完成各自任务，例如：应用程序启动类要确保在处理用户请求前，所有
 * N个外部系统已经启动和运行了。
 * 3. 死锁检测： 一个非常方便的使用场景是，你可以使用n个线程访问共享资源，
 * 在每次测试阶段的线程数目是不同的，并尝试产死锁
 *
 *
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args){
        CountDownLatch countDownLatch  = new CountDownLatch(2);
        Work work1 = new Work("zhang sang", 5000, countDownLatch);
        Work work2 = new Work("li si", 8000, countDownLatch);

        Thread thread = new Thread(work1);
        thread.start();


        Thread thread1 = new Thread(work2);
        thread1.start();

        try {
            countDownLatch.await();
            System.out.println("all work done at " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    static  class Work  implements  Runnable{

        private String workName;
        private int workTime;
        private CountDownLatch latch;


        public Work(String workName, int workTime, CountDownLatch countDownLatch){
            this.latch =countDownLatch;
            this.workName = workName;
            this.workTime = workTime;
        }

        @Override
        public void run() {
            System.out.println("worker " + workName  + "do work begin at " + new Date());
            doWork(); // 工作了
            System.out.println("worker " + workName + "do work complete at " + new Date());
            latch.countDown(); // 工人完成工作, 计数器减一
        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
