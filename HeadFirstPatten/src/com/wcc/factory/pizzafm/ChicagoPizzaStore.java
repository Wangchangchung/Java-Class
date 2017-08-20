package com.wcc.factory.pizzafm;

/**
 * Created by WCC on 2017/1/4.
 */
public class ChicagoPizzaStore  extends  PizzaStore{

    Pizza createPizza(String item) {
        if (item.equals("cheese")){
            return  new ChicagoStyleCheesePizza();
        }else if (item.equals("clam")){
            return  new ChicagoStyleClamPizza();
        }else if (item.equals("Veggin")){
            return  new ChicagoStyleVegginPizza();
        }
        return null;
    }
}
