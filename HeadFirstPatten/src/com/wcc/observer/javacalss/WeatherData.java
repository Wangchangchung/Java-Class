package com.wcc.observer.javacalss;

import com.wcc.observer.inferface.Observer;

import java.util.Observable;

/**
 * Created by WCC on 2017/1/2.
 * 使用Java内置的观察者模式：
 *
 *有了Java内置的支持，你只需要扩展(继承) Observable，并告诉它如何通知
 * 观察者，一切就完成了，剩下的就是API会帮你做。
 *
 * Java内置观察者的运作模式是怎么样的？
 * 1、如何把对象变成观察者？
 *      和以前一样, 实现观察者接口(java.uitl.Observer),然后调用任何Observable对象的addObserver()方法，
 *      不想再当观察者时，调用deleteObserver()方法就可以。
 * 2、观察者如何送出通知
 *      1、先调用setChanged()方法，标记状态已经改变的事实。
 *      2、然后调用两种notifyObservers()方法中的一个。
 *
 *
 *
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){}

    public void measurementsChanged(){
        // 在调用notifyObservers()之前，要要先调用setChanged()来指示
        // 状态已经改变。
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getTemperature() {
        return temperature;

    }
}
