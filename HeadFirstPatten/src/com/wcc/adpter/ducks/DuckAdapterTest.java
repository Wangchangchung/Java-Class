package com.wcc.adpter.ducks;

import org.testng.annotations.Test;

/**
 * Created by WCC on 2017/1/5.
 */
public class DuckAdapterTest {

    @Test
    public void testDuckAapter(){
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Turkey turkeyAdapter = new DuckAdapter(duck);

        System.out.println("火鸡");
        turkey.fly();
        turkey.gobble();
        System.out.println("鸭子----------");
        duck.fly();
        duck.quanck();
        System.out.println("适配器----------");
        turkeyAdapter.fly();
        turkeyAdapter.gobble();
        System.out.println("-----------");

    }
}
