package tasks.task04_16_11_2017.entities.concretePublishers;

import org.junit.jupiter.api.Test;
import tasks.task04_16_11_2017.entities.concreteObservers.PrimaryConditionsDisplayer;
import tasks.task04_16_11_2017.interfaces.Observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherStationTest {
    @Test
    void removeObserver() {
        WeatherStation ws = new WeatherStation();
        Observer o1 = new PrimaryConditionsDisplayer();
        ws.registerObserver(o1);
        ws.removeObserver(o1);
        ws.removeObserver(o1);

        int expected = 0;
        int result = ws.getObservers().size();

        assertEquals(expected, result);
    }

}