package com.wcc.factory.pizzas;

/**
 * Created by WCC on 2017/1/4.
 *
 * 一个简单的披萨工厂，专门用于生产各种的披萨
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("clam")){
            pizza = new ClamPizza();
        }else if (type.equals("veggie")){
            pizza = new VeggiePizza();
        }
        return  pizza;
    }
}
