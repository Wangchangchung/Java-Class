package com.wcc.thread;

/**
 * Created by charse on 17-5-1.
 */
public class ThreadDemo  implements  Runnable{


    @Override
    public void run() {
        System.out.println("this is in the run method");
    }
}
