package com.wcc.command;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by WCC on 2017/1/5.
 */
public class RematoControl {
    Command[] commandOn;
    Command[] commandOff;

    // 构造方法中谁两个Command数组进行初始化的操作。
    public RematoControl(){
        commandOn = new Command[3];
        commandOff = new Command[3];

        Command noCommend = null;
        for (int i = 0;  i < commandOff.length; ++i){
            commandOff[i] = noCommend;
            commandOn[i] = noCommend;
        }
    }

    // 设置某一个开管的光和闭
    public void setCommand(int slot, Command on, Command off){
        commandOn[slot] = on;
        commandOff[slot] = off;
    }
    // 当开的按钮按下的时候，就执行相对应的commandOn对象的execute 方法
    public void onButtonWasPushed(int slot){
        commandOn[slot].execute();
    }
    // 当关的按钮按下的时候，就指向相对应的commandOff对象的execute 方法
    public void offButtonWasPushed(int slot){
        commandOff[slot].execute();
    }

}
