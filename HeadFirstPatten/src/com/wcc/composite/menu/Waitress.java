package com.wcc.composite.menu;

import com.wcc.iterator.myinterface.*;

/**
 * Created by WCC on 2017/1/8.
 */
public class Waitress {
    MenuComponent allMuens;

    public  Waitress(MenuComponent allMuens){
        this.allMuens = allMuens;
    }

    public void printMenu(){
        allMuens.print();
    }
}
