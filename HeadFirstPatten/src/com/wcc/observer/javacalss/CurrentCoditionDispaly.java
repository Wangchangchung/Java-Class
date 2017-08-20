package com.wcc.observer.javacalss;

import com.wcc.observer.inferface.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by WCC on 2017/1/2.
 */
public class CurrentCoditionDispaly implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    Observable observable;

    public  CurrentCoditionDispaly(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display() {
        System.out.println("Current  conditions:" + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    /*
       实现 java.util.Observer接口中的update方法。
     */

    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData) obs;
            this.temperature  = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
