package com.wcc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by WCC on 2017/3/12.
 *
 * 同步是隐式的锁操作（内置锁）
 * 而Lock 对象是显示的锁操作
 *
 *
 */
public class Counter {
    private Lock lock = new ReentrantLock();
    public int count = 0;

    public void addCount(){
        lock.lock();
        try {
            // 临界区
           count++;
           System.out.println("count:" + count);

        }finally {
            // 如果在临界区抛出异常，必须保证锁被释放
            lock.unlock();
        }
    }




}
