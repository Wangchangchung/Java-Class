package com.wcc.factory.pizzas;

/**
 * Created by WCC on 2017/1/4.
 *
 *  VeggiePizza
 */
public class VeggiePizza extends Pizza {
    public  VeggiePizza(){
        name = "Veggie Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Shredded mozzarella");
        toppings.add("Grated parmesan");
        toppings.add("Diced onion");
        toppings.add("Sliced mushrooms");
        toppings.add("Sliced red pepper");
        toppings.add("Sliced black olives");
    }
}
