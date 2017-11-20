package tasks.task4_16_11_2017.helpers;

import tasks.task4_16_11_2017.entities.LocationInfo;

/**
 * Класс, формирующий ссылку запроса к серверу DarkSky
 */
public class DarkSkyUrlMaker {
    private static final String MAIN_URL = "https://api.darksky.net/forecast/";
    private final static String KEY = "77c8ea030878f5222612b72805671cc0";

    private final static String UNITS_SET = "units";
    private final static String UNITS = "si";

    private static String getPartOfUrl(String key, LocationInfo locationInfo, String exactTime) throws IllegalAccessException {
        return getPartOfUrl(key, locationInfo) + ',' + exactTime;
    }

    private static String getPartOfUrl(String key, LocationInfo locationInfo) throws IllegalAccessException {
        if (key == null || key.equals(""))
            throw new IllegalAccessException("The key is empty");
        if (locationInfo == null)
            throw new IllegalAccessException("The locationInfo is null");

        return MAIN_URL + key + '/' + locationInfo.getLatitude() + ',' + locationInfo.getLongitude();
    }

    public static String getUrl(LocationInfo locationInfo) throws IllegalAccessException {
        String result = getPartOfUrl(KEY, locationInfo);
        result += '?' + UNITS_SET + "=" + UNITS;
        return result;
    }

    public static String getUrl(LocationInfo locationInfo, String exactTime) throws IllegalAccessException {
        String result = getPartOfUrl(KEY, locationInfo, exactTime);
        result += '?' + UNITS_SET + "=" + UNITS;
        return result;
    }
}