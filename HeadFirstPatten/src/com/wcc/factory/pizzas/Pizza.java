package com.wcc.factory.pizzas;

import java.util.ArrayList;

/**
 * Created by WCC on 2017/1/4.
 *
 *  披萨抽象类
 *
 */
abstract  public class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new  ArrayList<String>();

    public String getName() {
        return name;
    }

    public void prepare(){
        System.out.println("Preparing " +  name);
    }

    public void bake(){
        System.out.println("Bake " + name);
    }
    public void cut(){
        System.out.println("Cut " + name);
    }

    public void box(){
        System.out.println("Box " + name);
    }

    @Override
    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("---" + name + "------\n") ;
        display.append(dough + '\n');
        display.append(sauce + '\n');
        for (String topping : toppings){
            display.append(topping + '\n');
        }
        return  display.toString();
    }
}
