package com.wcc.factory.pizzafm;

/**
 * Created by WCC on 2017/1/4.
 */
public class NYStyleVeggiePizza extends Pizza {

    public NYStyleVeggiePizza(){
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Garlic");
        toppings.add("Onion");
        toppings.add("Mushrooms");
        toppings.add("Red Pepper");
    }

}
