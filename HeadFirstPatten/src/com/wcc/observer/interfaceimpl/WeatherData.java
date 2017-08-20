package com.wcc.observer.interfaceimpl;

import com.wcc.observer.inferface.Observer;
import com.wcc.observer.inferface.Subject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by WCC on 2016/12/26.
 *
 * WeatherData 实现了Subject接口
 *
 */
public class WeatherData implements Subject {

    // 用数组来记录观察者
    private ArrayList observers;

    private float temperature;

    private float humdity;

    private float pressure;


    public WeatherData(){
        observers  = new ArrayList();
    }

    //当注册观察者时，我们将观察者添加到数组中
    public void registerObserver(Observer o) {
            this.observers.add(o);
    }
    //当观察者想取消注册，我们将观察者从数组中删除
    public void removeObserver(Observer o) {
        int i = observers.indexOf(0);
        if (i >= 0){
            observers.remove(o);
        }
    }

    //因为每一个观察者都实现了update方法，所以我们在这里可以通知所有的观察者
    public void notifyObsevers() {
        for (int i = 0; i < observers.size(); ++i){
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humdity, pressure);
        }
    }

    //当从气象站更新观测值时，我们通知观察者
    public void measurementChanged(){
        notifyObsevers();
    }

    //
    public void setMeassurements(float temperature, float humdity, float pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humdity = humdity;
        measurementChanged();
    }

    // WeatherData的其他方法
}
