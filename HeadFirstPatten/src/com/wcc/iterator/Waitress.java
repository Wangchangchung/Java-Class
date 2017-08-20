package com.wcc.iterator;

import com.wcc.iterator.myinterface.DinnerMenuIterator;
import com.wcc.iterator.myinterface.Iterator;
import com.wcc.iterator.myinterface.Menu;

import java.util.InputMismatchException;

/**
 * Created by WCC on 2017/1/8.
 */
public class Waitress {
    Menu pancakeHouseMenu;
    Menu  dinerMenu;

    // 构造区器中，传入两个菜单
    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu  = dinerMenu;
    }


    public void printMenu(){

        // printMenu 方法为每一个菜单各自创建一个迭代器
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinnerIterator = dinerMenu.createIterator();

        //打印早餐菜单和午餐菜单
        System.out.println("菜单:");
        System.out.println("早餐:");
        printMenu(pancakeIterator);

        System.out.println("午餐：");
        printMenu(dinnerIterator);
    }


    private void printMenu(Iterator iterator){
        // 判断是否还有下一个元素
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.getDescription());
        }
    }
}


