package com.wcc.observer.test;

/**
 * Created by WCC on 2017/1/2.
 */
public class WeatherData {
    //实例变量声明
    private float temperaure;
    private float humidity;
    private float pressure;

    /*
    public  void measuremntsChanged(){
        float temp = getTemperaure();
        float  humidity = getHumidity();
        float pressure = getPressure();
        // 三种布告的实例对象，将从WeatherData中的数据传入布告中。
        currentCOnditionDisplay.update(temp, humidity, pressure);
        statiscsDisplay.update(temp, humidity, pressure);
        forecastDispaly.update(temp, humidity, pressure);
    }
    */
    // WeatherData的其他方法

    public float getTemperaure() {
        return temperaure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
