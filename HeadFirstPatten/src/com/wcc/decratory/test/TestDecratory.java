package com.wcc.decratory.test;

import com.wcc.decratory.source.Beverage;
import com.wcc.decratory.type.*;
import org.testng.annotations.Test;

/**
 * Created by WCC on 2017/1/2.
 */
public class TestDecratory {
    @Test
    public void  testDecratory(){
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Soy(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
    }
}
