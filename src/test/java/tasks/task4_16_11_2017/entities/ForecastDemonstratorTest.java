package tasks.task4_16_11_2017.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.task4_16_11_2017.entities.concretePublishers.WeatherStation;
import tasks.task4_16_11_2017.exceptions.InvalidCoordinatesException;

import static org.junit.jupiter.api.Assertions.*;

class ForecastDemonstratorTest {
    @Test
    void demonstrate() {
        try {
            Location location = new Location(
                    "Ukraine", "Kiev", 50.433304, 30.516693);

            WeatherStation weatherStation = null;

            Assertions.assertThrows(NullPointerException.class, () -> {
                ForecastDemonstrator demon = new ForecastDemonstrator(location, weatherStation);
                demon.demonstrate();
            });
        } catch (InvalidCoordinatesException e) {
            fail("Wrong location created.");
        }
    }
}