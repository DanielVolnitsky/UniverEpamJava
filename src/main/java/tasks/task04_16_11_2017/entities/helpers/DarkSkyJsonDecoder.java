package tasks.task04_16_11_2017.entities.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tasks.task04_16_11_2017.entities.Forecast;

import java.util.Date;

/**
 * Класс, расшифровывающий json DarkSky
 *
 * @See DarkSkyUrlMaker
 * @See JsonHelper
 */
public class DarkSkyJsonDecoder {
    final String TEMPERATURE = "temperature";

    final String HUMIDITY = "humidity";
    final String PRESSURE = "pressure";

    final String WIND_SPEED = "windSpeed";
    final String WIND_GUST = "windGust";
    final String WIND_BEARING = "windBearing";

    final String TIME = "time";
    final String TYPE_HOURLY = "hourly";
    final String TYPE_CURRENTLY = "currently";
    final String DATA = "data";

    private JSONObject jsonObject;

    public DarkSkyJsonDecoder(JSONObject jsonObject) {
        if (jsonObject != null) {
            this.jsonObject = jsonObject;
        } else {
            throw new NullPointerException("jsonObject shouldn't be null.");
        }
    }

    public Forecast getForecastForExactDay(byte exactHour) throws JSONException {
        if (exactHour < -1 || exactHour > 23)
            exactHour = 0;

        JSONObject obj = jsonObject.getJSONObject(TYPE_HOURLY);
        JSONArray jsnForecasts = obj.getJSONArray(DATA);

        return getExactForecast(jsnForecasts.getJSONObject(exactHour), TYPE_HOURLY);
    }

    public Forecast getCurrentForecast() throws JSONException {
            /*Переходим к подмассиву currently*/
            JSONObject obj = jsonObject.getJSONObject(TYPE_CURRENTLY);
            return getExactForecast(obj, TYPE_CURRENTLY);
    }

    private Forecast getExactForecast(JSONObject obj, String type) throws JSONException {
        Forecast forecast = new Forecast();

        fillForecastByMeasurements(obj, forecast);
        forecast.setDate(new Date(obj.getLong(TIME) * 1000));
        return forecast;
    }

    private void fillForecastByMeasurements(JSONObject obj, Forecast forecast) throws JSONException {
        forecast.setTemp(obj.getDouble(TEMPERATURE));
        forecast.setHumidity(obj.getDouble(HUMIDITY));
        forecast.setPressure(obj.getDouble(PRESSURE));

        forecast.setWindSpeed(obj.getDouble(WIND_SPEED));
        forecast.setWindGust(obj.getDouble(WIND_GUST));
        forecast.setWindBearing(obj.getDouble(WIND_BEARING));
    }
}
