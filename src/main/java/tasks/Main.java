package tasks;


import org.json.JSONException;
import tasks.task4_16_11_2017.entities.CurrentConditionsDisplay;
import tasks.task4_16_11_2017.entities.Forecast;
import tasks.task4_16_11_2017.entities.LocationInfo;
import tasks.task4_16_11_2017.entities.WeatherData;
import tasks.task4_16_11_2017.entities.swing.ForecastFrame;
import tasks.task4_16_11_2017.exceptions.InvalidCoordinatesException;
import tasks.task4_16_11_2017.helpers.DarkSkyJsonDecoder;
import tasks.task4_16_11_2017.helpers.DarkSkyUrlMaker;
import tasks.task4_16_11_2017.helpers.DateHelper;
import tasks.task4_16_11_2017.helpers.JsonReader;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws JSONException {
        try {
            final LocationInfo locInfo = new LocationInfo(
                    "Ukraine", "Kiev", 50.433304, 30.516693);

            final ForecastFrame frame = new ForecastFrame(
                    locInfo.getCountryName() + ", " + locInfo.getCity());

            final WeatherData weatherData = new WeatherData();

            CurrentConditionsDisplay cdd = new CurrentConditionsDisplay(weatherData, frame.currWeatherArea);

            JsonReader reader = new JsonReader(DarkSkyUrlMaker.getUrl(locInfo, DateHelper.getYesterdayTime()));

            DarkSkyJsonDecoder prevDayInfo = new DarkSkyJsonDecoder(reader.getJsonText());
            Forecast prevDayForecast = prevDayInfo.getForecastForExactDay(DateHelper.getCurrentHour());

            frame.prevWeatherArea.setText(prevDayForecast.toString());
            frame.setVisible(true);

            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {

                    tryUpdatePrevDayHourlyValues();

                    JsonReader reader = null;
                    try {
                        reader = JsonReader.getDarkSkyJsonWithUrl(locInfo);
                    } catch (IllegalAccessException e) {
                        System.err.println("Problems with identifying.");
                    }

                    DarkSkyJsonDecoder thisDayDecoder = new DarkSkyJsonDecoder(reader.getJsonText());
                    Forecast todayForecast = thisDayDecoder.getCurrentForecast();

                    weatherData.setMeasurements(todayForecast);
                }

                private void tryUpdatePrevDayHourlyValues() {

                }
            }, 0, 3000);

        } catch (InvalidCoordinatesException | IllegalAccessException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
