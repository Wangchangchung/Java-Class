package com.wcc.observer.inferface;


/**
 * Created by WCC on 2016/12/26.
 */
public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObsevers();
}
