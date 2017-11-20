package tasks;


import org.json.JSONException;
import tasks.task4_16_11_2017.entities.CurrentConditionsDisplay;
import tasks.task4_16_11_2017.entities.Forecast;
import tasks.task4_16_11_2017.entities.LocationInfo;
import tasks.task4_16_11_2017.entities.WeatherData;
import tasks.task4_16_11_2017.entities.swing.ForecastGUI;
import tasks.task4_16_11_2017.helpers.DarkSkyUrlMaker;
import tasks.task4_16_11_2017.helpers.DateHelper;
import tasks.task4_16_11_2017.helpers.ForecastDecoder;
import tasks.task4_16_11_2017.helpers.JsonReader;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws JSONException {

        final LocationInfo locInfo = new LocationInfo(
                "Ukraine", "Kiev", "50.433304", "30.516693");

        final ForecastGUI myGui = new ForecastGUI(
                locInfo.getCountryName() + ", " + locInfo.getCity());

        final WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentCond = new CurrentConditionsDisplay(weatherData, myGui.currWeatherArea);

        JsonReader reader = null;
        try {
            reader = new JsonReader(DarkSkyUrlMaker.getUrl(locInfo, DateHelper.getYesterdayTime()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        ForecastDecoder prevDayDecoder = new ForecastDecoder(reader.readJson());
        Forecast yestForecast = prevDayDecoder.getForecastForExactDay(DateHelper.getCurrentHour());

        myGui.setVisible(true);
        myGui.prevWeatherArea.setText(yestForecast.toString());

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                JsonReader reader = null;
                try {
                    reader = new JsonReader(DarkSkyUrlMaker.getUrl(locInfo));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                ForecastDecoder thisDayDecoder = new ForecastDecoder(reader.readJson());
                Forecast todayForecast = null;
                try {
                    todayForecast = thisDayDecoder.getCurrentForecast();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                weatherData.setMeasurements(todayForecast);
            }
        }, 0, 5000);
    }
}
