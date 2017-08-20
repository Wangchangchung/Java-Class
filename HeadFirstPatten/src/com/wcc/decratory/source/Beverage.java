package com.wcc.decratory.source;

/**
 * Created by WCC on 2017/1/2.
 */
public abstract  class Beverage {
    public String  description = "Unknown Beverage";
    public String getDescription(){
        return  description;
    }
    public abstract double cost();
}
