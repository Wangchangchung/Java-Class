package com.wcc.command;

/**
 * Created by WCC on 2017/1/5.
 */
public class LightOnCommand implements  Command {
    Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
