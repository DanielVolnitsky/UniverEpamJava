package tasks;

import org.json.JSONException;
import tasks.task4_16_11_2017.entities.ForecastDemonstrator;
import tasks.task4_16_11_2017.entities.Location;
import tasks.task4_16_11_2017.entities.concretePublishers.WeatherStation;
import tasks.task4_16_11_2017.exceptions.InvalidCoordinatesException;

public class Main {
    public static void main(String[] args) throws JSONException {

        try {
            Location location = new Location(
                    "Ukraine", "Kiev", 50.433304, 30.516693);

            WeatherStation weatherStation = new WeatherStation();

            ForecastDemonstrator demon = new ForecastDemonstrator(location, weatherStation);
            demon.demonstrate();

        } catch (InvalidCoordinatesException e) {
            e.printStackTrace();
        }
    }
}