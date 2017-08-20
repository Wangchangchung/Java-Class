package com.wcc.decratory.type;

import com.wcc.decratory.source.Beverage;
import com.wcc.decratory.source.CondimentDecorator;

/**
 * Created by WCC on 2017/1/2.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }


    public double cost() {
        return .20 + beverage.cost();
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
