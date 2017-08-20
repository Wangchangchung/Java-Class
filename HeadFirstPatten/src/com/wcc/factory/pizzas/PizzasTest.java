package com.wcc.factory.pizzas;

import org.testng.annotations.Test;

/**
 * Created by WCC on 2017/1/4.
 */
public class PizzasTest {

    @Test
    public void testPizzas(){
        SimplePizzaFactory simplePizzaFactory =
                new SimplePizzaFactory();

        PizzaStore  pizzaStore = new PizzaStore(simplePizzaFactory);

        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("我们已经订购了：" + pizza.getName() +"\n");
        System.out.println(pizza);

        pizza = pizzaStore.orderPizza("clam");
        System.out.println("我们已经订购了：" + pizza.getName() + "\n");
        System.out.println(pizza);
    }

}
