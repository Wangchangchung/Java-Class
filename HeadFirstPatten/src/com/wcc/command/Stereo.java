package com.wcc.command;

/**
 * Created by WCC on 2017/1/5.
 */
public class Stereo {
    private  int volume ;

    public void on(){
        System.out.println("CD on");
    }
    public  void off(){
        System.out.println("CD off");
    }
    public void setVolume(int volume){
        this.volume = volume;
        System.out.println("volume is" + volume);
    }
}

