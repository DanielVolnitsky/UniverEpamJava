package tasks.task04_16_11_2017.interfaces;

import tasks.task04_16_11_2017.entities.Forecast;

/*Интерфейс, предназначенный для участников паттерна "Observer" - наблюдателей*/
public interface Observer {
    public void update(Forecast forecastState);
}
