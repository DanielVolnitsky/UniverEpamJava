package tasks.task4_16_11_2017.entities.helpers;

import tasks.task4_16_11_2017.entities.Location;
import tasks.task4_16_11_2017.interfaces.UrlMaker;

/**
 * Класс, формирующий ссылку запроса к серверу DarkSky
 */
public class DarkSkyUrlMaker implements UrlMaker{
    private static final String MAIN_URL = "https://api.darksky.net/forecast/";
    private final static String KEY = "77c8ea030878f5222612b72805671cc0";

    private final static String UNITS_SET = "units";
    private final static String UNITS = "si";

    private Location location;

    public DarkSkyUrlMaker(Location location) {
        this.location = location;
    }

    private String getPartOfUrl(String key, String exactTime) throws IllegalAccessException {
        return getPartOfUrl(key) + ',' + exactTime;
    }

    private String getPartOfUrl(String key) throws IllegalAccessException {
        if (key == null || key.equals(""))
            throw new IllegalAccessException("The key is empty");
        if (location == null)
            throw new IllegalAccessException("The location is null");

        return MAIN_URL + key + '/' + location.getLatitude() + ',' + location.getLongitude();
    }

    @Override
    public  String getUrl()  {
        String result = "";
        try {
            result = getPartOfUrl(KEY);
            result += '?' + UNITS_SET + "=" + UNITS;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getUrl(String exactTime) throws IllegalAccessException {
        String result = getPartOfUrl(KEY, exactTime);
        result += '?' + UNITS_SET + "=" + UNITS;
        return result;
    }
}