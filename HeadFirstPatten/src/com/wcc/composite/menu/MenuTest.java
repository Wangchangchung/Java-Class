package com.wcc.composite.menu;

import org.testng.annotations.Test;

/**
 * Created by WCC on 2017/1/8.
 */
public class MenuTest {

    @Test
    public  void TestMenu(){
        MenuComponent  pancakeHouseMenu = new Menu("Panckae house menu", "早餐");
        MenuComponent dinerMenu = new Menu("Diner Menu", "午餐") ;
        MenuComponent cafeMenu = new Menu("CafeeMenu", "晚餐");
        MenuComponent dessertMenu = new Menu("Dessert Menu", "甜点");

        MenuComponent allMenus=  new Menu("所有的菜单", "这是饭店中所有的菜单了！");

        // 将所有的菜单 都添加进这个 “根”菜单中
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);
        allMenus.add(dessertMenu);

        dessertMenu.add(new MenuItem("苹果派","非常好吃", true, 3.2));
        dessertMenu.add(new MenuItem("草莓派", "可爱极", true, 1.9));

        dessertMenu.add(new MenuItem("香橙排", "想动态一口", true, 8.9));

        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();
    }

}
