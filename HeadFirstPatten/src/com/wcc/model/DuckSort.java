package com.wcc.model;

import com.wcc.adpter.ducks.Duck;

/**
 * Created by WCC on 2017/1/8.
 */
public class DuckSort  implements  Comparable{
    String name;
    int weight;

    public DuckSort(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String toString(){
        return  name + "  : " + weight;
    }

    // 指定鸭子之间是如何比较的。
    public int compareTo(Object o) {
        DuckSort otherDuck = (DuckSort) o;
        if (this.weight < otherDuck.weight){
            return  -1;
        }else if(this.weight == otherDuck.weight){
            return 0;
        }else{
            return  1;
        }
     }
}
