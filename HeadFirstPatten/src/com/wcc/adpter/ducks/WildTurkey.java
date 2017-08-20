package com.wcc.adpter.ducks;

/**
 * Created by WCC on 2017/1/5.
 */
public class WildTurkey  implements  Turkey{
    public void gobble() {
        System.out.println("我是WildTurkey I am gobble !");
    }

    public void fly() {
        System.out.println("我是WildTurkey I am flying  a short distance !");
    }
}
