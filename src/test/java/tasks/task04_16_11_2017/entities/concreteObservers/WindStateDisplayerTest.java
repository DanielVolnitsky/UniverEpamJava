package tasks.task04_16_11_2017.entities.concreteObservers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.task04_16_11_2017.entities.Forecast;
import tasks.task04_16_11_2017.entities.concretePublishers.WeatherStation;

import javax.swing.*;

class WindStateDisplayerTest {
    @Test
    void update() {
        WeatherStation weatherStation = new WeatherStation();
        JTextArea jta = new JTextArea();
        Forecast f = null;

        Assertions.assertThrows(NullPointerException.class, () -> {
            WindStateDisplayer wsd = new WindStateDisplayer(weatherStation, jta);
            wsd.update(f);
        });
    }
}