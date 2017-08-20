package com.wcc.factory.pizzafm;

import org.testng.annotations.Test;

/**
 * Created by WCC on 2017/1/4.
 */
public class PizzaTest {

    @Test
    public void testPizza(){
        // 先创建两个商店
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        // 在纽约店里面订购一份cheese味的披萨
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println(pizza.getName() + "\n");

        // 在芝加哥店里面订购一个cheese味的披萨
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println(pizza.getName());

        //在纽约店里main订购一份clam披萨
        pizza = nyStore.orderPizza("clam");
        System.out.println(pizza.getName());

        pizza = chicagoStore.orderPizza("clam");
        System.out.println(pizza.getName());



    }
}
