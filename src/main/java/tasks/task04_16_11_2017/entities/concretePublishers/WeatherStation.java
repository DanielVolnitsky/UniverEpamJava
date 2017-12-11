package tasks.task04_16_11_2017.entities.concretePublishers;


import tasks.task04_16_11_2017.entities.Forecast;
import tasks.task04_16_11_2017.interfaces.Observer;
import tasks.task04_16_11_2017.interfaces.Publisher;

import java.util.ArrayList;

/**
 * Погодная станция, оповещающая своих "подписчиков" об изменениях в погоде
 *
 * @See Publisher
 */
public class WeatherStation implements Publisher {

    private ArrayList observers;
    private Forecast forecastState;

    public WeatherStation() {
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

    public ArrayList getObservers() {
        return observers;
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
