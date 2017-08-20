package com.wcc.volatil;

/**
 * Created by charse on 17-5-11.
 */
public class VolatileTest {

    public static  volatile  int race = 0;
    public  static  void  increase(){
        race++;
    }
    private  static  final  int THREADS_COUNT = 20;

    public  static  void  main(String[] args){
        System.out.println("----");
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; ++i){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i =0;i < 100; ++i){
                        increase();
                    }
                }
            });
            System.out.println("**" + i);
            threads[i].start();
        }

        while(Thread.activeCount() > 1){
           Thread.yield();
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(race);
    }
}
