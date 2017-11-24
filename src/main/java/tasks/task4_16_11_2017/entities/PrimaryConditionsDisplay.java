package tasks.task4_16_11_2017.entities;

import tasks.task4_16_11_2017.interfaces.DisplayElement;
import tasks.task4_16_11_2017.interfaces.Observer;
import tasks.task4_16_11_2017.interfaces.Subject;

import javax.swing.*;
import java.util.Date;

/**
 * наблюдатель изменений в классе WeatherData, часть локального паттерна "Observer"
 */
public class PrimaryConditionsDisplay implements Observer, DisplayElement {
    private JTextArea textArea;
    private Subject weatherData;

    private double temperature;
    private double humidity;
    private double pressure;

    private Date date;

    public PrimaryConditionsDisplay(Subject weatherData, JTextArea textArea) {
        this.textArea = textArea;
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(Forecast forecast) {
        this.date = forecast.getDate();

        this.temperature = forecast.getTemp();
        this.humidity = forecast.humidity;
        this.pressure = forecast.pressure;

        display();
    }

    @Override
    public void display() {
        StringBuilder text = new StringBuilder(30);
        text.append(date);
        text.append("\n\nTemperature: ");
        text.append(temperature);
        text.append("\nHumidity: ");
        text.append(humidity);
        text.append("\nPressure: ");
        text.append(pressure);

        textArea.setText(text.toString());
    }
}
