package com.wcc.factory.pizzafm;

/**
 * Created by WCC on 2017/1/4.
 */
public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza(){
        name = "NY Style Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }
}
