package com.wcc.observer.interfaceimpl;

import com.wcc.observer.inferface.DisplayElement;
import com.wcc.observer.inferface.Observer;

/**
 * Created by WCC on 2017/1/2.
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;
    private float  temperature;
    private  float humidity;
    private float pressure;

    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    public void display() {
        temperature+= 1;
        humidity+= 0.5;
        pressure+= 0.7;
        System.out.println("Forecast tempreature:"+ temperature+ " humkidity :"+ humidity
        +" pressure" + pressure);
    }
}
