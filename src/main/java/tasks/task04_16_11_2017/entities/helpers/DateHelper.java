package tasks.task04_16_11_2017.entities.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Класс, содержащий вспомогательные методы для работы с временем
 */
public class DateHelper {

    public static String getYesterdayTime() {
        int secsPerDay = 86400;
        long currTime = new Date().getTime();
        long cut = currTime / 1000;
        return Long.toString(cut - secsPerDay);
    }

    public static byte getCurrentHour() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        return (byte) calendar.get(Calendar.HOUR_OF_DAY);
    }
}
