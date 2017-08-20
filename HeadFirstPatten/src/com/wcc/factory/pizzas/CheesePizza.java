package com.wcc.factory.pizzas;

/**
 * Created by WCC on 2017/1/4.
 * CheesePizza 披萨
 */
public class CheesePizza extends Pizza {

    public  CheesePizza(){
        name = "Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
}
