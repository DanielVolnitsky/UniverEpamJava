package tasks.task4_16_11_2017.entities;

import tasks.task4_16_11_2017.interfaces.DisplayElement;
import tasks.task4_16_11_2017.interfaces.Observer;
import tasks.task4_16_11_2017.interfaces.Subject;

import javax.swing.*;
import java.util.Date;

/**
 * наблюдатель изменений в классе WeatherData, часть локального паттерна "Observer"
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private JTextArea textArea;
    private Subject weatherData;
    private double temperature;
    private Date date;

    public CurrentConditionsDisplay(Subject weatherData, JTextArea textArea) {
        this.textArea = textArea;
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(Forecast forecastState) {
        this.date = forecastState.getDate();
        this.temperature = forecastState.getTemp();
        display();
    }

    @Override
    public void display() {
        textArea.setText(date + "\nCurrent temperature: " + temperature + " c\n");
    }
}
