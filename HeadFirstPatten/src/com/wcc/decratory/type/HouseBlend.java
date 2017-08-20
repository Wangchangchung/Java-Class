package com.wcc.decratory.type;

import com.wcc.decratory.source.Beverage;

/**
 * Created by WCC on 2017/1/2.
 */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description = "House Blend Coffee";
    }

    public double cost() {
        return 0.89;
    }
}
