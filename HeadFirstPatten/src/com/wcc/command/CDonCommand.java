package com.wcc.command;

/**
 * Created by WCC on 2017/1/5.
 */
public class CDonCommand implements  Command {

    Stereo stereo;

    public CDonCommand(Stereo stereo){
        this.stereo = stereo;
    }
    public void execute() {
        stereo.on();
        stereo.setVolume(11);
    }
}
