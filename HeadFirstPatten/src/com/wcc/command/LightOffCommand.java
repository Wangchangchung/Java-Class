package com.wcc.command;

/**
 * Created by WCC on 2017/1/5.
 */
public class LightOffCommand implements  Command {
    Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}
