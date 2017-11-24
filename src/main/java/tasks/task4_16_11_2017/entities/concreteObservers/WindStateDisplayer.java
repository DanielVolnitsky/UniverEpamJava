package tasks.task4_16_11_2017.entities.concreteObservers;

import tasks.task4_16_11_2017.entities.Forecast;
import tasks.task4_16_11_2017.interfaces.Displayer;
import tasks.task4_16_11_2017.interfaces.Observer;
import tasks.task4_16_11_2017.interfaces.Publisher;

import javax.swing.*;
import java.util.Date;

public class WindStateDisplayer implements Observer, Displayer {

    private Date date;
    private JTextArea textArea;
    private Publisher weatherData;

    private double windSpeed;
    private double windGust;
    private double windBearing;

    public WindStateDisplayer(Publisher weatherData, JTextArea textArea) {
        this.textArea = textArea;
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }


    @Override
    public void update(Forecast forecast) {
        this.date = forecast.getDate();
        this.windSpeed = forecast.getWindSpeed();
        this.windGust = forecast.getWindGust();
        this.windBearing = forecast.getWindBearing();

        display();
    }

    @Override
    public void display() {
        StringBuilder result = new StringBuilder(30);
        result.append(date);
        result.append("\n\nWind speed: ");
        result.append(windSpeed);
        result.append("\nWind gust: ");
        result.append(windGust);
        result.append("\nWind bearing: ");
        result.append(windBearing);

        textArea.setText(result.toString());
    }
}
