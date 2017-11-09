package tasks.helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Класс содержит вспомогательные методы для task'ов текущего проекта
 */
public class Helper {

    public static int getRandomizedInt(int min, int max) {
        max -= min;
        return (int) (Math.random() * max) + min;
    }

    public static double getRandomizedDouble(double min, double max) {
        max -= min;
        return (Math.random() * max) + min;
    }

    /**
     * @param places - ко-во требуемых десятичных знаков
     */
    public static double getRandomizedRoundedDouble(double min, double max, int places) {
        max -= min;
        double randDouble = (Math.random() * max) + min;
        return round(randDouble, places);
    }

    /**
     * @param places - ко-во требуемых десятичных знаков
     */
    public static double getRoundedDouble(double value, int places) {
        return round(value, places);
    }

    /**
     * @param places - ко-во требуемых десятичных знаков
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
