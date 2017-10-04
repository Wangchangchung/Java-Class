package com.wcc.condition;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by charse on 17-10-2.
 * Exchange 一般用于工作线程之间的交换数据
 *
 * API 的叙述：
 * 1. 此类提供了对外的操作是同步的
 * 2. 用于成对线程之间的交换数据
 * 3. 可以视作双向的同步队列
 * 4. 可以用于基因算法，流水线设计场景
 *
 *
 */
public class ExchangerDemo {

    protected  static final Logger log = Logger.getLogger(String.valueOf(ExchangerDemo.class));

    private static volatile boolean isDone = false;



    static class ExchangerProducer implements Runnable{

        private Exchanger<Integer> exchanger;

        private static  int data = 1;

        ExchangerProducer(Exchanger<Integer> exchanger){
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (!Thread.interrupted() && !isDone){
                for (int i = 0; i <=3; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        data = i;
                        System.out.println("producer before:" + data);
                        data = exchanger.exchange(data);
                        System.out.println("producer after:" + data);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isDone = true;
            }
        }
    }

    static class ExchangeConsumer implements Runnable{

        private Exchanger<Integer> exchanger;
        private static int data = 0;

        ExchangeConsumer(Exchanger<Integer> exchanger){
            this.exchanger = exchanger;
        }


        @Override
        public void run() {
            while (!Thread.interrupted() && !isDone){
                data = 0;
                System.out.println("consumer before :" + data);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data = exchanger.exchange(data);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("consumer after:"  + data);
            }
        }
    }




    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Exchanger<Integer> exchanger = new Exchanger<>();

        ExchangerProducer producer = new ExchangerProducer(exchanger);
        ExchangeConsumer consumer = new ExchangeConsumer(exchanger);

        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.shutdown();

        try{
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
