package com.wcc.decratory.type;

import com.wcc.decratory.source.Beverage;
import com.wcc.decratory.source.CondimentDecorator;

/**
 * Created by WCC on 2017/1/2.
 */
public class Whip extends CondimentDecorator {
    Beverage beverage ;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription() {
        return  beverage.getDescription() + ", Whip";
    }

    public double cost() {
        return .40  + beverage.cost();
    }
}
