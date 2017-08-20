package com.wcc.model;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by WCC on 2017/1/8.
 */
public class TeaWhithHook extends CoffeineBeverage {

    void brew() {
        System.out.println("用热水 将茶叶浸泡");
    }

    void addCondiments() {
        System.out.println("在茶中添加 柠檬！");
    }
}
