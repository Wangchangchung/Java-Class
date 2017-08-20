package com.wcc.factory.pizzas;

/**
 * Created by WCC on 2017/1/4.
 *
 * 披萨店专门用于制作披萨, 通过一个简单的披萨工厂
 * 将一个用户订购的披萨生产出来。
 *
 */
public class PizzaStore {
        SimplePizzaFactory simplePizzaFactory ;


        public PizzaStore(SimplePizzaFactory simplePizzaFactory){
            this.simplePizzaFactory = simplePizzaFactory;
        }

        public Pizza orderPizza(String  type){
            Pizza pizza;

            pizza = simplePizzaFactory.createPizza(type);

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

            return  pizza;
        }
}
