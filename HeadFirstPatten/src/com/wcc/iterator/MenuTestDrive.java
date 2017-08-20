package com.wcc.iterator;

import org.testng.annotations.Test;

/**
 * Created by WCC on 2017/1/8.
 */
public class MenuTestDrive  {

    @Test
    public void testMenu(){
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }

}
