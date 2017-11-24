package tasks.task4_16_11_2017.entities;

import tasks.task4_16_11_2017.interfaces.DisplayElement;
import tasks.task4_16_11_2017.interfaces.Observer;
import tasks.task4_16_11_2017.interfaces.Subject;

import javax.swing.*;
import java.util.Date;

public class WindStateDisplay implements Observer, DisplayElement {

    private Date date;
    private JTextArea textArea;
    private Subject weatherData;

    private double windSpeed;
    private double windGust;
    private double windBearing;

    public WindStateDisplay(Subject weatherData, JTextArea textArea) {
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
        StringBuilder text = new StringBuilder(30);
        text.append(date);
        text.append("\n\nWind speed: ");
        text.append(windSpeed);
        text.append("\nWind gust: ");
        text.append(windGust);
        text.append("\nWind bearing: ");
        text.append(windBearing);

        textArea.setText(text.toString());
    }
}
