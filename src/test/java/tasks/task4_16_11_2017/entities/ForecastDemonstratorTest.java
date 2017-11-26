package tasks.task4_16_11_2017.entities;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task4_16_11_2017.entities.concretePublishers.WeatherStation;
import tasks.task4_16_11_2017.entities.helpers.DarkSkyJsonDecoder;
import tasks.task4_16_11_2017.entities.helpers.JsonHelper;
import tasks.task4_16_11_2017.exceptions.InvalidCoordinatesException;
import tasks.task6_23_11_2017.stringTask.entities.FileHelper;

import java.net.MalformedURLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ForecastDemonstratorTest {

    Location location;

    @BeforeEach
    void initializeComponents() {
        try {
            location = new Location(
                    "Ukraine", "Kiev", 50.433304, 30.516693);
        } catch (InvalidCoordinatesException e) {
            fail("Wrong location created.");
        }
    }

    @Test
    void demonstrate() {
        WeatherStation weatherStation = null;

        Assertions.assertThrows(NullPointerException.class, () -> {
            ForecastDemonstrator demon = new ForecastDemonstrator(location, weatherStation);
            demon.demonstrate();
        });
    }

    @Test
    void updateCurrentValues() {

        String filePath = "src\\main\\java\\tasks\\task4_16_11_2017\\additional\\jsonExample";
        String mockJsonText = new String(FileHelper.getFileBytes(filePath));

        JsonHelper mockito = mock(JsonHelper.class);
        try {
            JSONObject mockObject = new JSONObject(mockJsonText);

            when(mockito.getJsonObject()).thenReturn(mockObject);

            DarkSkyJsonDecoder decoder = new DarkSkyJsonDecoder(mockito.getJsonObject());
            Forecast result = decoder.getCurrentForecast();

            Forecast expected = new Forecast();
            expected.setDate(new Date(1511543027000L));
            expected.setTemp(-1.53);
            expected.setHumidity(0.97);
            expected.setPressure(1024.74);
            expected.setWindSpeed(1.46);
            expected.setWindGust(1.87);
            expected.setWindBearing(163.0);

            assertEquals(expected, result);

        } catch (MalformedURLException e) {
            fail("Bad url given.");
        } catch (JSONException e) {
            fail("invalid json.");
        }
    }
}