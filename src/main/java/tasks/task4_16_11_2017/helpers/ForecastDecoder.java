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
public class ForecastDecoder {
    final String TEMPERATURE = "temperature";
    final String TIME = "time";
    final String TYPE_HOURLY = "hourly";
    final String TYPE_CURRENTLY = "currently";
    final String DATA = "data";
    //    final String MIN_TEMP = "temperatureMax";
    //    final String MAX_TEMP = "temperatureMin";

    private JSONObject jsonObject;

    public ForecastDecoder(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Forecast getForecastForExactDay(byte exactHour) throws JSONException {
        JSONObject obj = jsonObject.getJSONObject(TYPE_HOURLY);
        JSONArray jsnForecasts = obj.getJSONArray(DATA);

        Forecast dayForecast = getDailyForecast(jsnForecasts.getJSONObject(exactHour), TYPE_HOURLY);
        return dayForecast;
    }

    public Forecast getCurrentForecast() throws JSONException {
        JSONObject obj = jsonObject.getJSONObject(TYPE_CURRENTLY);

        Forecast dayForecast = getDailyForecast(obj, TYPE_CURRENTLY);
        return dayForecast;
    }

//    public List<Forecast> getForecastsWeek() {
//        return getForecasts(TYPE_HOURLY);
//    }


//    private List<Forecast> getForecasts(String type) {
//        List<Forecast> forecasts = new ArrayList<>();
//
//        JSONObject object = jsonObject.getJSONObject(type);
//        JSONArray jsonForecasts = object.getJSONArray(DATA);
//
//        for (int i = 0; i < jsonForecasts.length(); i++) {
//            forecasts.add(getDailyForecast(jsonForecasts.getJSONObject(i), type));
//        }
//
//        return forecasts;
//    }

    private Forecast getDailyForecast(JSONObject obj, String type) throws JSONException {
        Forecast forecast = new Forecast();
        setTemperature(type, obj, forecast);
        forecast.setDate(new Date(obj.getLong(TIME) * 1000));
        return forecast;
    }

    private void setTemperature(String type, JSONObject obj, Forecast forecast) throws JSONException {
        switch (type) {
            case "currently":
            case "hourly":
                forecast.setTemp(obj.getDouble(TEMPERATURE));
                break;
//            case "daily":
//                double temp = (obj.getDouble(MIN_TEMP) + obj.getDouble(MAX_TEMP)) / 2;
//                forecast.setTemp(temp);
//                break;
        }
    }
}
