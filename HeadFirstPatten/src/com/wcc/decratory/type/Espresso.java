package com.wcc.decratory.type;

import com.wcc.decratory.source.Beverage;

/**
 * Created by WCC on 2017/1/2.
 */
public class Espresso extends Beverage {

    public Espresso(){
        description = "Espresso";
    }
    public double cost() {
        return 1.99;
    }
}
