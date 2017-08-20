package com.wcc.decratory.type;

import com.wcc.decratory.source.Beverage;
import com.wcc.decratory.source.CondimentDecorator;

/**
 * Created by WCC on 2017/1/2.
 */
public class Soy extends CondimentDecorator {
    Beverage beverage ;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return  .30  +  beverage.cost();
    }
}
