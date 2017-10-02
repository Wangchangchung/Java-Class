package com.wcc.lock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by charse on 17-8-29.
 *
 * 用读写锁实现一个　缓存系统,　当然这个缓存系统中的主要功能还是
 *
 * 取数据的时候进行的．
 *
 */
public class CacheTest {

    public HashMap<String, String > map = new HashMap<>();

    public Object data;

    public volatile boolean cachedDataValid;

    public final ReentrantReadWriteLock  rwl = new ReentrantReadWriteLock();


    public Object getData(){
            //　　多线程的情况下, 进行加读锁
            rwl.readLock().lock();
            try {
                //当缓存中没有数据，或者缓存失效之后，就进行才能从数据库
                //中进行抓取
                if (!cachedDataValid){
                    //将读锁放开, 获取写锁
                    rwl.readLock().unlock();
                    //在多线程的情况下，只有一个线程可以获取这个写锁
                    rwl.writeLock().lock();
                    try {

                        //　注意，这里要再次的检查, 是否有缓存了
                        //　因为第一个线程社会了data之后,释放了写锁，后面的线程就可以获取写锁
                        //　这样的化，就是重新的进行设置data的值，这样的性能是非常的差的，
                        //　所以这里一定要缜密

                        if (!cachedDataValid) {
                            data = map.get("data");
                            cachedDataValid = true;
                        }
                        //获取写锁
                        rwl.readLock().lock();

                    }finally {
                        rwl.writeLock().unlock();
                    }
                }
            }finally {
                rwl.readLock().unlock();
            }
            // usedata()

        try {
            // TODO usedata
        }finally {
            rwl.readLock().unlock();
        }

        return  data;
    }



    public static void main(String[] args){

    }

}
