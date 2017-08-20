package com.wcc.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by charse on 17-8-7.
 */
public class TraditionTimerTest {

    public  static  void  main(String[] args){

        //设置一个定时器　　Timer　是一个定时器　　TimerTask　具体的执行任务
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing !");
            }
        }, 10000);
    }
}

