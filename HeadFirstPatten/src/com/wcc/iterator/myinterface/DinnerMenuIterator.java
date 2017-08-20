package com.wcc.iterator.myinterface;

import com.wcc.iterator.MenuItem;

/**
 * Created by WCC on 2017/1/8.
 */
public class DinnerMenuIterator implements  Iterator {
    MenuItem[] items;
    int position = 0;
    //初始化 MenuItem
    public DinnerMenuIterator(MenuItem[] item){
        this.items = item;
    }
    // 判读是否有下一个元素
    public boolean hasNext() {
        if (position >= items.length || items[position] == null){
            return false;
        }else {
            return  true;
        }
    }
    // 读取下一个元素
    public Object next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
}
