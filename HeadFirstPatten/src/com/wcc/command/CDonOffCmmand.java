package com.wcc.command;

/**
 * Created by WCC on 2017/1/5.
 */
public class CDonOffCmmand implements  Command {

    Stereo stereo;

    public CDonOffCmmand(Stereo stereo){
        this.stereo = stereo;
    }
    public void execute() {
        stereo.off();
        stereo.setVolume(0);
    }
}
