package com.wcc.model;

/**
 * Created by WCC on 2017/1/8.
 */
public class CoffeeWithHook  extends CoffeineBeverage{
    void brew() {
        System.out.println("用热水将 咖啡浸泡！");
    }

    void addCondiments() {
        System.out.println("向咖啡中添加牛奶和糖！");
    }
}
