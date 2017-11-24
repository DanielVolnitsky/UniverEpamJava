package tasks.task4_16_11_2017.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tasks.task4_16_11_2017.entities.Forecast;

import java.util.Date;

/**
 * Класс, расшифровывающий json DarkSky
 *
 * @See DarkSkyUrlMaker
 * @See JsonReader
 */
public class DarkSkyJsonDecoder {
    final String TEMPERATURE = "temperature";
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

    public Forecast getCurrentForecast() {
        try {
            JSONObject obj = jsonObject.getJSONObject(TYPE_CURRENTLY);
            return getExactForecast(obj, TYPE_CURRENTLY);
        } catch (JSONException e) {
            return null;
        }
    }

    private Forecast getExactForecast(JSONObject obj, String type) throws JSONException {
        Forecast forecast = new Forecast();
        setTemperature(type, obj, forecast);
        forecast.setDate(new Date(obj.getLong(TIME) * 1000));
        return forecast;
    }

    void setTemperature(String type, JSONObject obj, Forecast forecast) throws JSONException {
        switch (type) {
            case "currently":
            case "hourly":
                forecast.setTemp(obj.getDouble(TEMPERATURE));
                break;
        }
    }
}
