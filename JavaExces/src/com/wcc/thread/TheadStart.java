package com.wcc.thread;

/**
 * Created by charse on 17-5-1.
 */
public class TheadStart {


    public  static  void  main(String[] args){
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        // 设置守护表示符  设置为 守护线程
        thread.setDaemon(true);


    }
}
