package com.wcc.factory.pizzafm;

/**
 * Created by WCC on 2017/1/4.
 */
public class NYPizzaStore extends  PizzaStore {

    Pizza createPizza(String item) {
        if (item.equals("cheese")){
            return new NYStyleCheesePizza();
        }else if (item.equals("clam")){
            return  new NYStyleClamPizza();
        }else if (item.equals("veggie")){
            return  new NYStyleVeggiePizza();
        }
        return null;
    }
}
