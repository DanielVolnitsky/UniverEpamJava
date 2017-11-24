package tasks.task4_16_11_2017.entities.concreteObservers;

import tasks.task4_16_11_2017.entities.Forecast;
import tasks.task4_16_11_2017.interfaces.Displayer;
import tasks.task4_16_11_2017.interfaces.Observer;
import tasks.task4_16_11_2017.interfaces.Publisher;

import javax.swing.*;
import java.util.Date;

/**
 * наблюдатель изменений в классе WeatherStation, часть локального паттерна "Observer"
 */
public class PrimaryConditionsDisplayer implements Observer, Displayer {
    private JTextArea textArea;
    private Publisher weatherData;

    private double temperature;
    private double humidity;
    private double pressure;

    private Date date;

    public PrimaryConditionsDisplayer(Publisher weatherData, JTextArea textArea) {
        this.textArea = textArea;
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(Forecast forecast) {
        this.date = forecast.getDate();

        this.temperature = forecast.getTemp();
        this.humidity = forecast.getHumidity();
        this.pressure = forecast.getPressure();

        display();
    }

    @Override
    public void display() {
        StringBuilder result = new StringBuilder(30);
        result.append(date);
        result.append("\n\nTemperature: ");
        result.append(temperature);
        result.append("\nHumidity: ");
        result.append(humidity);
        result.append("\nPressure: ");
        result.append(pressure);

        textArea.setText(result.toString());
    }
}
