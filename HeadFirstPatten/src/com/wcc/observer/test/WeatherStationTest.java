package com.wcc.observer.test;

import com.wcc.observer.interfaceimpl.CurrentConditionDisplay;
import com.wcc.observer.interfaceimpl.ForecastDisplay;
import com.wcc.observer.interfaceimpl.WeatherData;
import com.wcc.observer.javacalss.CurrentCoditionDispaly;
import org.testng.annotations.Test;

/**
 * Created by WCC on 2016/12/26.
 */
public class WeatherStationTest {


    @Test
    public void testCurrentConditionDispay(){
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay conditionDisplay =  new CurrentConditionDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeassurements(30, 56, 78);
        System.out.println("-------------------------------------");
        weatherData.setMeassurements(23,45,34);
    }


   /* @Test
    public void testJavaCurrentConditionDispay(){
        com.wcc.observer.javacalss.WeatherData  weatherData = new com.wcc.observer.javacalss.WeatherData();
        CurrentCoditionDispaly coditionDispaly = new CurrentCoditionDispaly(weatherData);
        weatherData.setMeasurements(21,22,12);
        System.out.println("-----------------------------");
        weatherData.setMeasurements(33,33,33);

    }*/

}
