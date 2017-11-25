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

        String mockJsonText = "{\"currently\":{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":3.14,\"windGust\":1.87,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0.94,\"windBearing\":163,\"apparentTemperature\":-3.43,\"pressure\":1024.74,\"dewPoint\":-1.91,\"ozone\":300.34,\"temperature\":-1.53,\"humidity\":0.97,\"time\":1511543027,\"windSpeed\":1.46,\"uvIndex\":0},\"offset\":2,\"timezone\":\"Europe/Kiev\",\"latitude\":50.433304,\"daily\":{\"data\":[{\"windGust\":2.73,\"apparentTemperatureMinTime\":1511503200,\"temperatureMax\":-0.97,\"icon\":\"fog\",\"precipIntensityMax\":0,\"windBearing\":143,\"ozone\":300.17,\"temperatureMaxTime\":1511528400,\"apparentTemperatureMin\":-5.01,\"sunsetTime\":1511532260,\"temperatureLow\":-1.82,\"humidity\":0.96,\"moonPhase\":0.18,\"windSpeed\":1.16,\"apparentTemperatureLowTime\":1511546400,\"sunriseTime\":1511501274,\"apparentTemperatureLow\":-4.66,\"summary\":\"Foggy in the evening.\",\"precipProbability\":0,\"temperatureHighTime\":1511528400,\"visibility\":4.12,\"precipIntensity\":0,\"cloudCover\":0.57,\"temperatureMin\":-4.86,\"apparentTemperatureHighTime\":1511528400,\"pressure\":1024.29,\"dewPoint\":-3.24,\"temperatureMinTime\":1511488800,\"uvIndexTime\":1511510400,\"apparentTemperatureMax\":-3.16,\"temperatureHigh\":-0.97,\"temperatureLowTime\":1511546400,\"apparentTemperatureHigh\":-3.16,\"time\":1511474400,\"windGustTime\":1511553600,\"uvIndex\":1,\"apparentTemperatureMaxTime\":1511528400}]},\"flags\":{\"sources\":[\"isd\",\"cmc\",\"gfs\",\"madis\"],\"isd-stations\":[\"331350-99999\",\"332220-99999\",\"332280-99999\",\"332310-99999\",\"332360-99999\",\"332460-99999\",\"333250-99999\",\"333390-99999\",\"333450-99999\",\"333451-99999\",\"333460-99999\",\"333470-99999\",\"333560-99999\",\"333620-99999\",\"334640-99999\",\"334660-99999\"],\"units\":\"si\"},\"hourly\":{\"summary\":\"Foggy until morning.\",\"data\":[{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":2.7,\"windGust\":0.01,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0,\"windBearing\":239,\"apparentTemperature\":-4.09,\"pressure\":1024.08,\"dewPoint\":-4.65,\"ozone\":294.98,\"temperature\":-4.09,\"humidity\":0.96,\"time\":1511474400,\"windSpeed\":0.34,\"uvIndex\":0},{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":2.14,\"windGust\":0.01,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0,\"windBearing\":218,\"apparentTemperature\":-4.75,\"pressure\":1024.07,\"dewPoint\":-5.32,\"ozone\":295.79,\"temperature\":-4.75,\"humidity\":0.96,\"time\":1511478000,\"windSpeed\":0.35,\"uvIndex\":0},{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":1.9,\"windGust\":0.01,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0,\"windBearing\":248,\"apparentTemperature\":-4.26,\"pressure\":1023.43,\"dewPoint\":-4.74,\"ozone\":298.51,\"temperature\":-4.26,\"humidity\":0.96,\"time\":1511481600,\"windSpeed\":0.17,\"uvIndex\":0},{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":2.59,\"windGust\":0.01,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0.01,\"windBearing\":223,\"apparentTemperature\":-4.75,\"pressure\":1023.43,\"dewPoint\":-5.24,\"ozone\":299.24,\"temperature\":-4.75,\"humidity\":0.96,\"time\":1511485200,\"windSpeed\":0.43,\"uvIndex\":0},{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":2.45,\"windGust\":0.01,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0.02,\"windBearing\":160,\"apparentTemperature\":-4.86,\"pressure\":1023.53,\"dewPoint\":-5.44,\"ozone\":299.5,\"temperature\":-4.86,\"humidity\":0.96,\"time\":1511488800,\"windSpeed\":0.19,\"uvIndex\":0},{\"summary\":\"Partly Cloudy\",\"precipProbability\":0,\"visibility\":4.2,\"windGust\":0.01,\"precipIntensity\":0,\"icon\":\"partly-cloudy-night\",\"cloudCover\":0.29,\"windBearing\":106,\"apparentTemperature\":-4.7,\"pressure\":1023.66,\"dewPoint\":-5.18,\"ozone\":299.79,\"temperature\":-4.7,\"humidity\":0.96,\"time\":1511492400,\"windSpeed\":0.71,\"uvIndex\":0},{\"summary\":\"Partly Cloudy\",\"precipProbability\":0,\"visibility\":3.44,\"windGust\":0.01,\"precipIntensity\":0,\"icon\":\"partly-cloudy-night\",\"cloudCover\":0.34,\"windBearing\":95,\"apparentTemperature\":-4.6,\"pressure\":1023.88,\"dewPoint\":-4.82,\"ozone\":300.07,\"temperature\":-4.6,\"humidity\":0.98,\"time\":1511496000,\"windSpeed\":1.07,\"uvIndex\":0},{\"summary\":\"Clear\",\"precipProbability\":0,\"visibility\":3.7,\"windGust\":0.02,\"precipIntensity\":0,\"icon\":\"clear-night\",\"cloudCover\":0.03,\"windBearing\":96,\"apparentTemperature\":-4.39,\"pressure\":1024.11,\"dewPoint\":-4.88,\"ozone\":300.29,\"temperature\":-4.39,\"humidity\":0.96,\"time\":1511499600,\"windSpeed\":0.96,\"uvIndex\":0},{\"summary\":\"Clear\",\"precipProbability\":0,\"visibility\":3.88,\"windGust\":0.91,\"precipIntensity\":0,\"icon\":\"clear-day\",\"cloudCover\":0.22,\"windBearing\":110,\"apparentTemperature\":-5.01,\"pressure\":1024.31,\"dewPoint\":-3.29,\"ozone\":301.63,\"temperature\":-3.07,\"humidity\":0.98,\"time\":1511503200,\"windSpeed\":1.36,\"uvIndex\":0},{\"summary\":\"Mostly Cloudy\",\"precipProbability\":0,\"visibility\":5.07,\"windGust\":1.35,\"precipIntensity\":0,\"icon\":\"partly-cloudy-day\",\"cloudCover\":0.61,\"windBearing\":128,\"apparentTemperature\":-4.91,\"pressure\":1024.32,\"dewPoint\":-3.19,\"ozone\":301.93,\"temperature\":-2.98,\"humidity\":0.98,\"time\":1511506800,\"windSpeed\":1.37,\"uvIndex\":0},{\"summary\":\"Mostly Cloudy\",\"precipProbability\":0,\"visibility\":5.54,\"windGust\":1.36,\"precipIntensity\":0,\"icon\":\"partly-cloudy-day\",\"cloudCover\":0.74,\"windBearing\":132,\"apparentTemperature\":-4.53,\"pressure\":1024.27,\"dewPoint\":-2.86,\"ozone\":302.21,\"temperature\":-2.22,\"humidity\":0.95,\"time\":1511510400,\"windSpeed\":1.65,\"uvIndex\":1},{\"summary\":\"Mostly Cloudy\",\"precipProbability\":0,\"visibility\":4.89,\"windGust\":2.25,\"precipIntensity\":0,\"icon\":\"partly-cloudy-day\",\"cloudCover\":0.81,\"windBearing\":128,\"apparentTemperature\":-4.44,\"pressure\":1024.24,\"dewPoint\":-2.93,\"ozone\":302.35,\"temperature\":-2.12,\"humidity\":0.94,\"time\":1511514000,\"windSpeed\":1.66,\"uvIndex\":1},{\"summary\":\"Overcast\",\"precipProbability\":0,\"visibility\":3.98,\"windGust\":1.36,\"precipIntensity\":0,\"icon\":\"cloudy\",\"cloudCover\":0.98,\"windBearing\":147,\"apparentTemperature\":-4.22,\"pressure\":1024.19,\"dewPoint\":-2.67,\"ozone\":302.27,\"temperature\":-2.02,\"humidity\":0.95,\"time\":1511517600,\"windSpeed\":1.6,\"uvIndex\":1},{\"summary\":\"Overcast\",\"precipProbability\":0,\"visibility\":4.49,\"windGust\":0.93,\"precipIntensity\":0,\"icon\":\"cloudy\",\"cloudCover\":0.98,\"windBearing\":131,\"apparentTemperature\":-3.76,\"pressure\":1024.15,\"dewPoint\":-2.19,\"ozone\":302.08,\"temperature\":-1.63,\"humidity\":0.96,\"time\":1511521200,\"windSpeed\":1.59,\"uvIndex\":1},{\"summary\":\"Overcast\",\"precipProbability\":0,\"visibility\":6.28,\"windGust\":0.93,\"precipIntensity\":0,\"icon\":\"cloudy\",\"cloudCover\":0.99,\"windBearing\":154,\"apparentTemperature\":-3.19,\"pressure\":1024.57,\"dewPoint\":-1.89,\"ozone\":304.8,\"temperature\":-1.06,\"humidity\":0.94,\"time\":1511524800,\"windSpeed\":1.65,\"uvIndex\":0},{\"summary\":\"Mostly Cloudy\",\"precipProbability\":0,\"visibility\":6.65,\"windGust\":2.26,\"precipIntensity\":0,\"icon\":\"partly-cloudy-day\",\"cloudCover\":0.81,\"windBearing\":136,\"apparentTemperature\":-3.16,\"pressure\":1024.57,\"dewPoint\":-1.98,\"ozone\":304.48,\"temperature\":-0.97,\"humidity\":0.93,\"time\":1511528400,\"windSpeed\":1.69,\"uvIndex\":0},{\"summary\":\"Mostly Cloudy\",\"precipProbability\":0,\"visibility\":6.44,\"windGust\":2.26,\"precipIntensity\":0,\"icon\":\"partly-cloudy-night\",\"cloudCover\":0.84,\"windBearing\":131,\"apparentTemperature\":-3.33,\"pressure\":1024.52,\"dewPoint\":-2.14,\"ozone\":303.53,\"temperature\":-1.16,\"humidity\":0.93,\"time\":1511532000,\"windSpeed\":1.66,\"uvIndex\":0},{\"summary\":\"Mostly Cloudy\",\"precipProbability\":0,\"visibility\":5.99,\"windGust\":2.72,\"precipIntensity\":0,\"icon\":\"partly-cloudy-night\",\"cloudCover\":0.89,\"windBearing\":128,\"apparentTemperature\":-3.32,\"pressure\":1024.49,\"dewPoint\":-2.33,\"ozone\":302.48,\"temperature\":-1.42,\"humidity\":0.93,\"time\":1511535600,\"windSpeed\":1.47,\"uvIndex\":0},{\"summary\":\"Overcast\",\"precipProbability\":0,\"visibility\":5.05,\"windGust\":2.28,\"precipIntensity\":0,\"icon\":\"cloudy\",\"cloudCover\":0.94,\"windBearing\":136,\"apparentTemperature\":-4,\"pressure\":1024.58,\"dewPoint\":-2.33,\"ozone\":301.53,\"temperature\":-1.51,\"humidity\":0.94,\"time\":1511539200,\"windSpeed\":1.84,\"uvIndex\":0},{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":3.19,\"windGust\":1.84,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0.94,\"windBearing\":163,\"apparentTemperature\":-3.34,\"pressure\":1024.72,\"dewPoint\":-1.89,\"ozone\":300.52,\"temperature\":-1.51,\"humidity\":0.97,\"time\":1511542800,\"windSpeed\":1.42,\"uvIndex\":0},{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":2.59,\"windGust\":2.28,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0.84,\"windBearing\":161,\"apparentTemperature\":-4.66,\"pressure\":1024.92,\"dewPoint\":-2.12,\"ozone\":297.68,\"temperature\":-1.82,\"humidity\":0.98,\"time\":1511546400,\"windSpeed\":2.06,\"uvIndex\":0},{\"summary\":\"Foggy\",\"precipProbability\":0,\"visibility\":3.17,\"windGust\":1.84,\"precipIntensity\":0,\"icon\":\"fog\",\"cloudCover\":0.84,\"windBearing\":160,\"apparentTemperature\":-3.88,\"pressure\":1024.98,\"dewPoint\":-2.12,\"ozone\":296.8,\"temperature\":-1.82,\"humidity\":0.98,\"time\":1511550000,\"windSpeed\":1.53,\"uvIndex\":0},{\"summary\":\"Mostly Cloudy\",\"precipProbability\":0,\"visibility\":3.99,\"windGust\":2.73,\"precipIntensity\":0,\"icon\":\"partly-cloudy-night\",\"cloudCover\":0.84,\"windBearing\":162,\"apparentTemperature\":-4.52,\"pressure\":1025,\"dewPoint\":-1.82,\"ozone\":296.23,\"temperature\":-1.51,\"humidity\":0.98,\"time\":1511553600,\"windSpeed\":2.24,\"uvIndex\":0},{\"summary\":\"Mostly Cloudy\",\"precipProbability\":0,\"visibility\":4.52,\"windGust\":2.28,\"precipIntensity\":0,\"icon\":\"partly-cloudy-night\",\"cloudCover\":0.69,\"windBearing\":180,\"apparentTemperature\":-4.07,\"pressure\":1024.95,\"dewPoint\":-1.82,\"ozone\":295.44,\"temperature\":-1.16,\"humidity\":0.95,\"time\":1511557200,\"windSpeed\":2.21,\"uvIndex\":0}],\"icon\":\"fog\"},\"longitude\":30.516693}";

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