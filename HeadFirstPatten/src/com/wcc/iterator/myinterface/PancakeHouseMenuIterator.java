package com.wcc.iterator.myinterface;

import com.wcc.iterator.MenuItem;

import java.util.ArrayList;

/**
 * Created by WCC on 2017/1/8.
 */
public class PancakeHouseMenuIterator implements Iterator {
    ArrayList<MenuItem> items;
    int position = 0;

    //初始化这个ArrayList
    public PancakeHouseMenuIterator(ArrayList<MenuItem> items){
        this.items = items;
    }

    //判断是否有下一个元素
    public boolean hasNext() {
        if (position >= items.size()){
            return false;
        }else {
            return true;
        }
    }
    // 将下一个元素读取
    public Object next() {
        MenuItem item =  items.get(position);
        position++;
        return item;
    }
}
