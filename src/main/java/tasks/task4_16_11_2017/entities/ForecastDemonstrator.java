package tasks.task4_16_11_2017.entities;

import org.json.JSONException;
import tasks.task4_16_11_2017.entities.swing.DisplayingFrame;
import tasks.task4_16_11_2017.exceptions.InvalidCoordinatesException;
import tasks.task4_16_11_2017.helpers.DarkSkyJsonDecoder;
import tasks.task4_16_11_2017.helpers.DarkSkyUrlMaker;
import tasks.task4_16_11_2017.helpers.DateHelper;
import tasks.task4_16_11_2017.helpers.JsonReader;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class ForecastDemonstrator {

    private static byte currHour;
    private static LocationInfo locInfo;
    private static WeatherData weatherData;

    private static void updateCurrentValues() {
        try {
            JsonReader currReader = JsonReader.getDarkSkyJsonWithUrl(locInfo);
            DarkSkyJsonDecoder thisDayDecoder = new DarkSkyJsonDecoder(currReader.getJsonText());

            Forecast thisDayForecast = thisDayDecoder.getCurrentForecast();
            weatherData.setMeasurements(thisDayForecast);
        } catch (IllegalAccessException e) {
            System.err.println("Problems with identifying.");
        }
    }

    private static void updatePrevDayValues(JTextArea textArea, byte exactHour) {
        try {
            JsonReader yestReader = new JsonReader(DarkSkyUrlMaker.getUrl(locInfo, DateHelper.getYesterdayTime()));
            DarkSkyJsonDecoder prevDayDecoder = new DarkSkyJsonDecoder(yestReader.getJsonText());
            try {
                Forecast prevDayForecast = prevDayDecoder.getForecastForExactDay(exactHour);
                textArea.setText(prevDayForecast.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            System.err.println("Problems with identifying.");
        }
    }

    public void demonstrate() {
        try {
            locInfo = new LocationInfo(
                    "Ukraine", "Kiev", 50.433304, 30.516693);

            final DisplayingFrame currPrimaryDataFrame = new DisplayingFrame("This moment weather state:");
            final DisplayingFrame currWindStateFrame = new DisplayingFrame("Current wind state:");
            final DisplayingFrame prevPrimaryDataFrame = new DisplayingFrame("Previous day weather state:");

            weatherData = new WeatherData();

            PrimaryConditionsDisplay primaryConditionsDisplay = new PrimaryConditionsDisplay(
                    weatherData, currPrimaryDataFrame.textArea);

            WindStateDisplay windStateDisplay = new WindStateDisplay(
                    weatherData, currWindStateFrame.textArea);

            currHour = DateHelper.getCurrentHour();
            updatePrevDayValues(prevPrimaryDataFrame.textArea, currHour);

            currPrimaryDataFrame.setVisible(true);
            currPrimaryDataFrame.centerFrame();

            currWindStateFrame.setVisible(true);
            currWindStateFrame.leftyFrame();

            prevPrimaryDataFrame.setVisible(true);
            prevPrimaryDataFrame.rightyFrame();

            java.util.Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    updateCurrentValues();

                    byte newHour = DateHelper.getCurrentHour();
                    if (newHour != currHour) {
                        currHour = newHour;
                        updatePrevDayValues(prevPrimaryDataFrame.textArea, currHour);
                    }
                }
            }, 0, 3000);

        } catch (InvalidCoordinatesException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
