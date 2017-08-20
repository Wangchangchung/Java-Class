package com.wcc.factory.pizzafm;

import com.wcc.factory.pizzas.*;

/**
 * Created by WCC on 2017/1/4.
 */
public abstract  class PizzaStore {
    abstract Pizza createPizza(String item);

    public Pizza orderPizza(String type){

        Pizza pizza = createPizza(type);
        System.out.println("----Making a " + pizza.getName() +"----");

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return  pizza;
    }

}
