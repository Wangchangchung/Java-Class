package com.wcc.adpter.ducks;

/**
 * Created by WCC on 2017/1/5.
 *适配的对象
 *      继承要被适配的对象
 *
 */
public class DuckAdapter  implements  Turkey{

    private Duck duck;

    public DuckAdapter(Duck duck){
        this.duck  = duck;
    }

    public void gobble() {
         duck.quanck();
    }

    public void fly() {
        duck.fly();
    }
}
