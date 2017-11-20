package tasks.task4_16_11_2017.entities;


import tasks.task4_16_11_2017.interfaces.Observer;
import tasks.task4_16_11_2017.interfaces.Subject;

import java.util.ArrayList;

/**
 * Погодная станция, оповещающая своих "подписчиков" об изменениях в погоде
 *
 * @See Subject
 */
public class WeatherData implements Subject {

    private ArrayList observers;
    private Forecast forecastState;

    public WeatherData() {
        this.observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0)
            observers.remove(i);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(forecastState);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    /*Тело формирования погоды*/
    public void setMeasurements(Forecast forecastState) {
        this.forecastState = forecastState;
        measurementsChanged();
    }
}
