package tasks.task4_16_11_2017.entities;

import org.json.JSONException;
import tasks.task4_16_11_2017.entities.concreteObservers.PrimaryConditionsDisplayer;
import tasks.task4_16_11_2017.entities.concreteObservers.WindStateDisplayer;
import tasks.task4_16_11_2017.entities.concretePublishers.WeatherStation;
import tasks.task4_16_11_2017.entities.helpers.DarkSkyJsonDecoder;
import tasks.task4_16_11_2017.entities.helpers.DarkSkyUrlMaker;
import tasks.task4_16_11_2017.entities.helpers.DateHelper;
import tasks.task4_16_11_2017.entities.helpers.JsonHelper;
import tasks.task4_16_11_2017.entities.swing.ForecastFrame;
import tasks.task4_16_11_2017.interfaces.UrlMaker;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class ForecastDemonstrator {

    private static byte currHour;
    private Location location;
    private WeatherStation weatherStation;

    public ForecastDemonstrator(Location location, WeatherStation weatherStation) {
        this.location = location;
        this.weatherStation = weatherStation;
    }

    public void demonstrate() {

        final ForecastFrame currPrimaryDataFrame = new ForecastFrame(
                "This moment weather state:", ForecastFrame.PositionType.CENTER);
        final ForecastFrame currWindStateFrame = new ForecastFrame(
                "Current wind state:", ForecastFrame.PositionType.LEFTY);
        final ForecastFrame prevPrimaryDataFrame = new ForecastFrame(
                "Previous day weather state:", ForecastFrame.PositionType.RIGHTY);

        PrimaryConditionsDisplayer primaryConditionsDisplayer = new PrimaryConditionsDisplayer(
                weatherStation, currPrimaryDataFrame.textHolder);

        WindStateDisplayer windStateDisplayer = new WindStateDisplayer(
                weatherStation, currWindStateFrame.textHolder);

        currHour = DateHelper.getCurrentHour();
        updatePrevDayValues(prevPrimaryDataFrame.textHolder, currHour);

        currPrimaryDataFrame.setVisible(true);
        currWindStateFrame.setVisible(true);
        prevPrimaryDataFrame.setVisible(true);

        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                updateCurrentValues();

                byte newHour = DateHelper.getCurrentHour();
                if (newHour != currHour) {
                    currHour = newHour;
                    updatePrevDayValues(prevPrimaryDataFrame.textHolder, currHour);
                }
            }
        }, 0, 3000);
    }

    private void updateCurrentValues() {
        UrlMaker urlMaker = new DarkSkyUrlMaker(location);
        JsonHelper jHelper = new JsonHelper(urlMaker.getUrl());
        DarkSkyJsonDecoder decoder = new DarkSkyJsonDecoder(jHelper.getJsonObject());

        Forecast forecast = null;
        try {
            forecast = decoder.getCurrentForecast();
        } catch (JSONException e) {
            System.err.println("Problems with json parsing.");
        }
        weatherStation.setMeasurements(forecast);
    }

    private void updatePrevDayValues(JTextArea textArea, byte exactHour) {
        try {
            DarkSkyUrlMaker urlMaker = new DarkSkyUrlMaker(location);
            JsonHelper jHelper = new JsonHelper(urlMaker.getUrl(DateHelper.getYesterdayTime()));
            DarkSkyJsonDecoder decoder = new DarkSkyJsonDecoder(jHelper.getJsonObject());
            try {
                Forecast forecast = decoder.getForecastForExactDay(exactHour);
                textArea.setText(forecast.toString());
            } catch (JSONException e) {
                System.err.println("Problems with json parsing.");
            }
        } catch (IllegalAccessException e) {
            System.err.println("Problems with identifying.");
        }
    }
}
