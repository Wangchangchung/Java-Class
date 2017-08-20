package com.wcc.model;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by WCC on 2017/1/8.
 */
public class ModelTest {
    @Test
    public void testModel(){
        TeaWhithHook teaWhithHook = new TeaWhithHook();
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
        teaWhithHook.prepareRecipe();
        System.out.println("----------------------------------");
        coffeeWithHook.prepareRecipe();

    }

    /**
     * 测试 Duck 的排序
     * DuckSort实现Comparable接口后 实现比价的方法就是可以进行和对象之间的比较了
     *
     * Array类中的sort() 模板方法：
     * for(int i = low; i < hight; ++i){
     *     ... compareTo()...
     *     ...swap()...
     * }
     *
     * sort方法控制算法，没有类可以改变这一点，sort() 依赖一个Comparable类提供
     * compareTo() 的实现。
     *
     * Arrays中的这个sort就是一个模板设计模式：
     *有时候荒野中的模式并非是像教科书中的例子一样那么的中规中矩
     * 为了符合当前额环境和实现的约束，他们总是要被适当的进行修改。
     *
     * Arrays中的sort方法是符合模板方法的精神的。再者，由于不需要继承数组就能够使用这个算法
     * 这样使得排序变得更有弹性，更有用。
     *
     * 还有哪些Java的API中使用的是模板方法的例子？
     * java.io的InputStream类又一个read()方法，是由子类实现的，
     * 而这个方法又被read(byte b[], int off, int len) 模板方法使用
     * 还有Swing Applet
     */
    @Test
    public void testDuckComp(){
        DuckSort[] ducks ={
                new DuckSort("hello", 2),
                new DuckSort("Dalu", 20),
                new DuckSort("Tandg", 22),
                new DuckSort("Huey", 21),
                new DuckSort("Def", 32)
        };

        System.out.println("Before sorting:");
        dispaly(ducks);

        System.out.println("After sotring:");
        Arrays.sort(ducks);
        dispaly(ducks);
    }

    public static void dispaly(DuckSort[] ducks){
        for (int i = 0 ; i < ducks.length; ++i){
            System.out.println(ducks[i]);
        }
    }
}
