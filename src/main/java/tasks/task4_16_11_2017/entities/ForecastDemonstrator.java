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
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

public class ForecastDemonstrator {

    private static byte currHour;
    private Location location;
    private WeatherStation weatherStation;

    public ForecastDemonstrator(Location location, WeatherStation weatherStation) throws NullPointerException {
        if (location != null && weatherStation != null) {
            this.weatherStation = weatherStation;
            this.location = location;
        } else
            throw new NullPointerException("ForecastDemonstrator params can not be null");
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

     void updateCurrentValues() {
        UrlMaker urlMaker = new DarkSkyUrlMaker(location);
        JsonHelper jHelper = new JsonHelper(urlMaker.getUrl());

        try {
            DarkSkyJsonDecoder decoder = new DarkSkyJsonDecoder(jHelper.getJsonObject());
            Forecast forecast = decoder.getCurrentForecast();

            weatherStation.setMeasurements(forecast);
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL formed.");
        } catch (JSONException e) {
            System.err.println("Problems with json parsing.");
        }
    }

    private void updatePrevDayValues(JTextArea textArea, byte exactHour) {
        DarkSkyUrlMaker urlMaker = new DarkSkyUrlMaker(location);
        JsonHelper jHelper = new JsonHelper(urlMaker.getUrl(DateHelper.getYesterdayTime()));
        try {
            DarkSkyJsonDecoder decoder = new DarkSkyJsonDecoder(jHelper.getJsonObject());
            Forecast forecast = decoder.getForecastForExactDay(exactHour);

            textArea.setText(forecast.toString());
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL formed.");
        } catch (JSONException e) {
            System.err.println("Problems with json parsing.");
        }
    }
}
