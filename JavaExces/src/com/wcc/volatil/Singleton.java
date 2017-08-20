package com.wcc.volatil;

/**
 * Created by charse on 17-5-11.
 */
public class Singleton {
    private  volatile  static  Singleton  instance;

    public static  Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return  instance;
    }


    public  static  void  main(String[] args){
        Singleton.getInstance();
    }
}
