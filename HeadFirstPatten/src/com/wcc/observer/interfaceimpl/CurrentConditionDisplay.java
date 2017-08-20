package com.wcc.observer.interfaceimpl;

import com.wcc.observer.inferface.DisplayElement;
import com.wcc.observer.inferface.Observer;
import com.wcc.observer.inferface.Subject;

import java.awt.peer.DialogPeer;

/**
 * Created by WCC on 2016/12/26.
 * 目前状况 布告的观察者
 */
public class CurrentConditionDisplay  implements Observer, DisplayElement{

    private float temperature;
    private float humifity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        /*
            这里为什么要保存Subject的引用呢？构造完似乎用不着了呀？
                的确如此，但是我们可能以后想要取消注册，如果已经有了对
                Subject的引用会比较方便
         */

        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humifity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions:" + temperature  + "F degrees " +
                "and " + humifity + "% humifity");
    }
}
