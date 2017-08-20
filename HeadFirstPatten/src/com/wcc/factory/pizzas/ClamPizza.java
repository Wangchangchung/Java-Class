package com.wcc.factory.pizzas;

import java.awt.datatransfer.Clipboard;

/**
 * Created by WCC on 2017/1/4.
 * ClamPizza
 */
public class ClamPizza extends Pizza {

    public ClamPizza(){
        name = "Clam Pizza";
        dough = "Thin crust";
        sauce = "White garlic sacue";
        toppings.add("Clams");
        toppings.add("Grated parmne cheese");
    }
}
