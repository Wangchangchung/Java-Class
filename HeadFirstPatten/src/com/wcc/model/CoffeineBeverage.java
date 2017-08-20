package com.wcc.model;

/**
 * Created by WCC on 2017/1/8.
 */
public abstract  class CoffeineBeverage {

    final  void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();
    abstract  void addCondiments();

    void boilWater(){
        System.out.println("烧开 开水！");
    }
    void pourInCup(){
        System.out.println("将饮料倒进杯子！");
    }
}
