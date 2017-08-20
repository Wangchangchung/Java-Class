package com.wcc.factory.pizzafm;

/**
 * Created by WCC on 2017/1/4.
 */
public class ChicagoStyleVegginPizza extends Pizza {
    public ChicagoStyleVegginPizza() {
        name = "Chicago Deep Dish Veggie Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Black Olives");
        toppings.add("Spinach");
        toppings.add("Eggplant");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }

}
