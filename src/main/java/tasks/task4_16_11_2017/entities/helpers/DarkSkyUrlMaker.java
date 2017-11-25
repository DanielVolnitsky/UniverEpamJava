package tasks.task4_16_11_2017.entities.helpers;

import tasks.task4_16_11_2017.entities.Location;
import tasks.task4_16_11_2017.interfaces.UrlMaker;

/**
 * Класс, формирующий ссылку запроса к серверу DarkSky
 */
public class DarkSkyUrlMaker implements UrlMaker {
    private static final String MAIN_URL = "https://api.darksky.net/forecast/";
    private final static String KEY = "77c8ea030878f5222612b72805671cc0";

    private final static String UNITS_SET = "units";
    private final static String UNITS = "si";

    private Location location;

    public DarkSkyUrlMaker(Location location) throws NullPointerException {
        if (location != null)
            this.location = location;
        else
            throw new NullPointerException();
    }

    private String getPartOfUrl(String exactTime) {
        return getPartOfUrl() + ',' + exactTime;
    }

    private String getPartOfUrl() {
        return MAIN_URL + KEY + '/' + location.getLatitude() + ',' + location.getLongitude();
    }

    @Override
    public String getUrl() {
        String result = getPartOfUrl();
        result += '?' + UNITS_SET + "=" + UNITS;
        return result;
    }

    public String getUrl(String exactTime) {
        String result = getPartOfUrl(exactTime);
        result += '?' + UNITS_SET + "=" + UNITS;
        return result;
    }
}